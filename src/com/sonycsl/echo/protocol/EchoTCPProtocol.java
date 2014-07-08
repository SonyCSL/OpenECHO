
package com.sonycsl.echo.protocol;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EchoTCPProtocol extends EchoProtocol {

    public static int TCP_MAX_PACKET_SIZE = 65507;

    private static final int PORT = 3610;

    private static final int TIMEOUT = 0;

    // for TCP.
    private ServerSocket mServerSocket;
    // private static ExecutorService sConnectedTCPSocketThreads;
    private Thread mSocketAcceptThread;
    // may be connected from same source many times.
    private HashMap<String, ArrayList<Socket>> mTCPSockets;

    public void openTCP() throws IOException {
        // tcp
        mTCPSockets = new HashMap<String, ArrayList<Socket>>();

        mServerSocket = new ServerSocket();
        mServerSocket.setSoTimeout(0);
        mServerSocket.setReuseAddress(true);
        mServerSocket.bind(new InetSocketAddress(PORT));
        // sConnectedTCPSocketThreads = Executors.newCachedThreadPool();
        mSocketAcceptThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isOpened()) {
                    try {
                        accept();
                    } catch (IOException e) {
                        // e.printStackTrace();
                        break;
                    }
                }
            }
        });
        mSocketAcceptThread.start();
    }

    public void closeTCP() throws IOException {
        if (mServerSocket != null) {
            ServerSocket s = mServerSocket;
            mServerSocket = null;
            s.close();
        }
        if (mSocketAcceptThread != null) {
            mSocketAcceptThread.interrupt();
            try {
                mSocketAcceptThread.join();
            } catch (Exception e) {
            }
            mSocketAcceptThread = null;
        }

        if (mTCPSockets != null) {
            for (Map.Entry<String, ArrayList<Socket>> entry : mTCPSockets.entrySet()) {
                for (Socket s : entry.getValue()) {
                    s.close();
                    s = null;
                }
            }
            mTCPSockets = null;
        }
        // if we have no socket,there is no need to receive.
        // stopReceiverThread();
    }

    public boolean isOpened() {
        return (mServerSocket != null && !mServerSocket.isClosed());
    }

    public void sendTCP(EchoFrame frame) throws IOException {
        Echo.getEventListener().sendEvent(frame);
        // will not occur?
        if (EchoSocket.SELF_ADDRESS.equals(frame.getDstEchoAddress())) {
            sendToSelf(frame.copy());
            return;
        } else if (EchoSocket.MULTICAST_ADDRESS.equals(frame.getDstEchoAddress())) {
            sendToGroup(frame.copy(), getKnownAddressSet());
            return;
        } else {
            sendToOther(frame.copy());
            return;
        }
    }

    public Set<String> getKnownAddressSet() {

        Set<String> set = new HashSet<String>();
        set.add(EchoSocket.SELF_ADDRESS);
        for (String address : mTCPSockets.keySet()) {
            set.add(address);
        }
        return set;
    }

    public void sendTCPFrame(EchoFrame frame, Socket socket) throws IOException {
        byte[] data = frame.getFrameByteArray();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.write(data);
    }

    public EchoFrame receive(Socket socket) throws IOException {
        // DataOutputStream out = new DataOutputStream(sock.getOutputStream());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        String address = socket.getInetAddress().getHostAddress();
        EchoFrame frame = null;
        try {
            frame = EchoFrame.getEchoFrameFromStream(address, in);
            return frame;
        } catch (SocketTimeoutException e) {
            throw e;
        } catch (IOException e) {
            // e.printStackTrace();
            closeTCPSocket(socket);
            throw e;
        }
    }

    public void accept() throws IOException {
        // has been closed?
        if (mServerSocket == null) {
            // System.err.println("TCP server socket has been closed.");
            return;
        }
        Socket sock = mServerSocket.accept();
        sock.setSoTimeout(TIMEOUT);
        String address = sock.getInetAddress().getHostAddress();
        if (mTCPSockets.containsKey(address)) {
            mTCPSockets.get(address).add(sock);
        } else {
            ArrayList<Socket> list = new ArrayList<Socket>();
            list.add(sock);
            mTCPSockets.put(address, list);
        }
        System.err.println("Socket add" + sock.getInetAddress() + "(income)");

        createReceiver(sock);

        // sConnectedTCPSocketThreads.execute(new TCPSocketThread(sock));
    }

    private void createReceiver(final Socket sock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (sock != null && !sock.isClosed()) {
                    try {
                        receive(sock);
                    } catch (IOException e) {
                        break;
                    }
                }
            }
        }).start();
    }

    public void closeTCPSocket(Socket socket) {
        if (socket != null && mTCPSockets != null) {
            ArrayList<Socket> list = mTCPSockets.get(socket.getInetAddress().getHostAddress());
            list.remove(socket);

            try {
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static class TCPProtocolTask extends EchoProtocol.Task {
        protected EchoTCPProtocol mTCPProtocol;
        protected Socket mSocket;

        public TCPProtocolTask(EchoFrame frame, EchoTCPProtocol protocol, Socket socket) {
            super(frame);
            mTCPProtocol = protocol;
            mSocket = socket; // boolean isFrameFromSelfNode () { return
                              // (mSocket == null) }
        }

        @Override
        protected void respond(EchoFrame response) {

            if (mSocket == null) {
                mTCPProtocol.sendToSelf(response);
            } else {
                try {
                    mTCPProtocol.sendTCPFrame(response, mSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void informAll(EchoFrame response) {

            Set<String> set = mTCPProtocol.getKnownAddressSet();
            if (mSocket == null) {
                set.remove(EchoSocket.SELF_ADDRESS);
                EchoFrame frame = response.copy();
                frame.setDstEchoAddress(EchoSocket.SELF_ADDRESS);
                mTCPProtocol.sendToSelf(frame);
            } else {
                String adr = mSocket.getInetAddress().getHostAddress();
                set.remove(adr);

                EchoFrame frame = response.copy();
                frame.setDstEchoAddress(adr);
                try {
                    mTCPProtocol.sendTCPFrame(frame, mSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                mTCPProtocol.sendToGroup(response.copy(), set);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected boolean isFrameFromSelfNode() {
            return (mSocket == null);
        }
    }

    protected void sendToSelf(EchoFrame frame) {
        TCPProtocolTask task = new TCPProtocolTask(frame, this, null);
        EchoSocket.enqueueTask(task);
    }

    protected void sendToOther(EchoFrame frame) throws IOException {
        InetAddress address = InetAddress.getByName(frame.getDstEchoAddress());

        if (mTCPSockets.containsKey(frame.getDstEchoAddress())) {
            ArrayList<Socket> list = mTCPSockets.get(frame.getDstEchoAddress());
            // 既存のsocketを新しいものから試す．
            for (int i = list.size() - 1; i >= 0; --i) {
                Socket sock = list.get(i);
                try {
                    // System.err.println("Reuse " + sock.getInetAddress() +
                    // " [" + i + "]");
                    sendTCPFrame(frame, sock);
                    return;
                } catch (IOException e) {
                    closeTCPSocket(sock);
                    continue;
                }
            }
        }

        // 既存のsocketが使えない場合
        Socket sock = new Socket(address, PORT);
        sock.setSoTimeout(TIMEOUT);
        // System.err.println("Socket add" + sock.getInetAddress());

        sendTCPFrame(frame, sock);
        if (mTCPSockets.containsKey(address.getHostAddress())) {
            mTCPSockets.get(address.getHostAddress()).add(sock);
        } else {
            ArrayList<Socket> list = new ArrayList<Socket>();
            list.add(sock);
            mTCPSockets.put(address.getHostAddress(), list);
        }
        // at first,read. 要求電文に対する応答電文は同一のコネクションで送信するものとする。
        // sConnectedTCPSocketThreads.execute(new TCPSocketThread(sock));
    }

    protected void sendToGroup(EchoFrame frame, Set<String> addressSet) throws IOException {
        for (String address : addressSet) {
            EchoFrame f = frame.copy();
            f.setDstEchoAddress(address);
            if (EchoSocket.SELF_ADDRESS.equals(address)) {
                sendToSelf(f);
            } else {
                sendToOther(f);
            }
        }

    }

    @Override
    public void receive() {
    }
}

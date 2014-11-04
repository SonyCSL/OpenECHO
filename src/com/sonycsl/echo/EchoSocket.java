/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Sony Computer Science Laboratories, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonycsl.echo;

import com.sonycsl.echo.protocol.EchoProtocol;
import com.sonycsl.echo.protocol.EchoProtocol.Task;
import com.sonycsl.echo.protocol.EchoTCPProtocol;
import com.sonycsl.echo.protocol.EchoUDPProtocol;

import java.io.IOException;
import java.net.NetworkInterface;
import java.util.concurrent.LinkedBlockingQueue;

public final class EchoSocket {
    @SuppressWarnings("unused")
    private static final String TAG = EchoSocket.class.getSimpleName();

    public static final String SELF_ADDRESS = "127.0.0.1";
    public static final String MULTICAST_ADDRESS = "224.0.23.0";

    protected static LinkedBlockingQueue<EchoProtocol.Task> sTaskQueue = new LinkedBlockingQueue<EchoProtocol.Task>();

    public static synchronized void enqueueTask(Task task) {
        sTaskQueue.offer(task);
    }

    private static EchoUDPProtocol sUDPProtocol = new EchoUDPProtocol();
    private static EchoTCPProtocol sTCPProtocol = new EchoTCPProtocol();

    private static Thread udpThread;
    private static Thread sTaskPerformerThread;
    private static short sNextTID = 0;
    private static boolean fPerformActive;

    private EchoSocket() {
    }

    public static void openSocket() throws IOException {
        sUDPProtocol.openUDP();
        sTCPProtocol.openTCP();
        startReceiverThread();
    }

    public static void openSocket(NetworkInterface nwif) throws IOException {
        sUDPProtocol.openUDP(nwif);
        sTCPProtocol.openTCP();
        startReceiverThread();
    }

    private static void startReceiverThread() {
        if (udpThread == null) {
            udpThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (sUDPProtocol.isOpened()) {
                        // System.out.println("UDP receive");
                        sUDPProtocol.receive();
                    }
                }
            });
            udpThread.start();
        }

        if (sTaskPerformerThread == null) {
            fPerformActive = true;
            sTaskPerformerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (fPerformActive) {
                        try {
                            // System.out.println( "perform" );
                            sTaskQueue.take().perform();
                        } catch (InterruptedException e) {
                            // e.printStackTrace();
                        }
                    }
                }
            });
            sTaskPerformerThread.start();
        }
    }

    public static void closeSocket() throws IOException {
        sTCPProtocol.closeTCP();
        sUDPProtocol.closeUDP();
        stopReceiverThread();
    }

    private static void stopReceiverThread() {
        if (udpThread != null) {
            udpThread.interrupt();
            try {
                udpThread.join();
            } catch (Exception e) {
            }
            udpThread = null;
        }

        if (sTaskPerformerThread != null) {
            fPerformActive = false;
            sTaskPerformerThread.interrupt();
            try {
                sTaskPerformerThread.join();
            } catch (Exception e) {
            }
            sTaskPerformerThread = null;
        }
    }

    public static void resumeReceiverThread() {

    }

    public static void pauseReceiverThread() {

    }

    public static synchronized short nextTID() {
        short ret = sNextTID;
        sNextTID += 1;
        // Echo::getStorage().get()->setNextTID(sNextTID);
        return ret;
    }

    public static short getNextTIDNoIncrement() {
        return sNextTID;
    }

    public static void sendUDPFrame(EchoFrame frame) throws IOException {
        sUDPProtocol.sendUDP(frame);
    }

    public static void sendTCPFrame(EchoFrame frame) throws IOException {
        sTCPProtocol.sendTCP(frame);
    }
}

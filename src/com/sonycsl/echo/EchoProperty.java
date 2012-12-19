package com.sonycsl.echo;

public class EchoProperty {

	public final byte epc;
	public final byte pdc;
	public final byte[] edt;
	
	public EchoProperty(byte epc, byte pdc, byte[] edt) {
		this.epc = epc;
		this.pdc = pdc;
		this.edt = edt;
	}
	
	public EchoProperty(byte epc, byte[] edt) {
		this(epc, (edt == null) ? (byte)0 : (byte)edt.length, edt);
	}
	
	public EchoProperty(byte epc) {
		this(epc, (byte)0, new byte[0]);
	}
	

	public int size() {
		if(edt != null) return edt.length + 2;
		return 2;
	}
}

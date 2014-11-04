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
	
	public EchoProperty copy() {
		EchoProperty ret;
		if(edt == null) {
			ret = new EchoProperty(epc, null);
		} else {
			byte[] edt_ = new byte[edt.length];
			for(int i = 0; i < edt.length; i++) {
				edt_[i] = edt[i];
			}
			ret = new EchoProperty(epc, edt_);
		}
		return ret;
	}
}

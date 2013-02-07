package com.MAVLink.Messages;

import java.util.ArrayList;
import java.util.List;

public class MAVLinkPayload {

	public static List<Byte> payload;

	public MAVLinkPayload() {
		payload = new ArrayList<Byte>();
	}
	
	public static List<Byte> getData() {
		return payload;
	}

	public static int size() {
		return payload.size();
	}

	public void add(byte c) {
		payload.add(c);		
	}

}
package com.MAVLink.Messages;

import java.util.ArrayList;
import java.util.List;

public class MAVLinkPayload {

	public static List<Byte> payload;
	public int index;

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

	public void resetIndex() {
		index = 0;
	}

	public byte getByte() {
		int result = 0;
		result |= (payload.get(index + 0) & 0xFF);
		index += 1;
		return (byte) result;
	}

	public short getShort() {
		int result = 0;
		result |= (payload.get(index + 1) & 0xFF) << 8;
		result |= (payload.get(index + 0) & 0xFF);
		index += 2;
		return (short) result;
	}

	public int getInt() {
		int result = 0;
		result |= (payload.get(index + 3) & 0xFF) << 24;
		result |= (payload.get(index + 2) & 0xFF) << 16;
		result |= (payload.get(index + 1) & 0xFF) << 8;
		result |= (payload.get(index + 0) & 0xFF);
		index += 4;
		return (int) result;
	}

	public long getLong() {
		long result = 0;
		result |= (payload.get(index + 7) & 0xFF) << 56;
		result |= (payload.get(index + 6) & 0xFF) << 48;
		result |= (payload.get(index + 5) & 0xFF) << 40;
		result |= (payload.get(index + 4) & 0xFF) << 32;
		result |= (payload.get(index + 3) & 0xFF) << 24;
		result |= (payload.get(index + 2) & 0xFF) << 16;
		result |= (payload.get(index + 1) & 0xFF) << 8;
		result |= (payload.get(index + 0) & 0xFF);
		index += 8;
		return (long) result;
	}

	public float getFloat() {
		return Float.intBitsToFloat(getInt());
	}

}
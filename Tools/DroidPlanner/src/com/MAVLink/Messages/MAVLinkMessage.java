package com.MAVLink.Messages;

import java.util.List;


public class MAVLinkMessage {
	/**
	 *  Simply a common interface for all MAVLink Messages
	 */
	
	public int messageType = -1;
	
	public int seq;

	public int len;

	public  int sysid;

	public int compid;

	public int msgid;

	public List<Integer> payload;
	
	public CRC crc;
	
	/*
	private Integer getInt64(int i){
		return payload.get(i) << 32  | (payload.get(i+4) & 0xFFFFFFFF);
	}*/
	
	public static Integer getInt32(int i,List<Integer> payload){
		 return payload.get(i+3) << 24 | (payload.get(i+2) & 0xFF) << 16 | payload.get(i+1) & 0xFF << 8 | (payload.get(i) & 0xFF);
	}
	

	public static Integer getInt8(int i,List<Integer> payload){
		 return payload.get(i);
	}

	public static float getFloat(int i,List<Integer> payload) {
		return Float.intBitsToFloat(getInt32(i,payload));
	}
	
	public void generateCRC(){
		crc = new CRC();
		crc.update_checksum(len);
		crc.update_checksum(seq);
		crc.update_checksum(sysid);
		crc.update_checksum(compid);
		crc.update_checksum(msgid);
		for (Integer data : payload) {
			crc.update_checksum(data);			
		}
		crc.finish_checksum(msgid);
	}
	
}

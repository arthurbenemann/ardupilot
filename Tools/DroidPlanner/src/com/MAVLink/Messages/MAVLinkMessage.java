package com.MAVLink.Messages;

import java.util.List;

import android.util.Log;

import com.MAVLink.Messages.ardupilotmega.msg_attitude;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;


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
	
	public MAVLinkMessage unpackMessage() {
		switch (msgid) {
		case msg_heartbeat.MAVLINK_MSG_ID_HEARTBEAT:
			Log.d("MAVLink", "HEARTBEAT");
			return msg_heartbeat.unpack(payload);
		case msg_attitude.MAVLINK_MSG_ID_ATTITUDE:
			Log.d("MAVLink", "ATTITUDE");
			return msg_attitude.unpack(payload);
			/*
			 * case msg_gps_raw.MAVLINK_MSG_ID_GPS_RAW: Log.d("MAVLink", "GPS");
			 * return unpackGPS_RAW(); case
			 * msg_sys_status.MAVLINK_MSG_ID_SYS_STATUS: Log.d("MAVLink",
			 * "SYS_STATUS"); break; case
			 * msg_waypoint_current.MAVLINK_MSG_ID_WAYPOINT_CURRENT:
			 * Log.d("MAVLink", "WAYPOINT_CURRENT"); break; case
			 * msg_global_position_int.MAVLINK_MSG_ID_GLOBAL_POSITION_INT:
			 * Log.d("MAVLink", "GLOBAL_POSITION_INT"); break; case
			 * msg_statustext.MAVLINK_MSG_ID_STATUSTEXT: Log.d("MAVLink",
			 * "STATUSTEXT"); break; case msg_vfr_hud.MAVLINK_MSG_ID_VFR_HUD:
			 * Log.d("MAVLink", "VRF_HUD"); break;
			 */
		default:
			Log.d("MAVLink", "UNKNOW MESSAGE - " + msgid);
			return null;
		}
	}


	public boolean payloadIsFilled() {
		return (payload.size() == len);
	}

	/*
	 * private MAVLinkMessage unpackGPS_RAW() { msg_gps_raw m = new
	 * msg_gps_raw(); m.usec = getInt64(0); m.fix_type = getInt8(8); m.lat =
	 * getInt32(12); m.lon = getInt32(16); m.alt = getInt32(20); m.eph =
	 * getInt16(24); m.epv = getInt16(26); m.v = getInt16(28); m. =
	 * getInt16(28); return m; }
	 */
}

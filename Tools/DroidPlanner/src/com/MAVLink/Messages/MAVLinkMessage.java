
package com.MAVLink.Messages;

public class MAVLinkMessage {
	/**
	 *  Simply a common interface for all MAVLink Messages
	 */
	
	public  int sysid;
	public int compid;
	public int msgid;
	

	/*
	 * private MAVLinkMessage unpackGPS_RAW() { msg_gps_raw m = new
	 * msg_gps_raw(); m.usec = getInt64(0); m.fix_type = getInt8(8); m.lat =
	 * getInt32(12); m.lon = getInt32(16); m.alt = getInt32(20); m.eph =
	 * getInt16(24); m.epv = getInt16(26); m.v = getInt16(28); m. =
	 * getInt16(28); return m; }
	 */
}
	

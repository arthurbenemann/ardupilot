package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_gps_raw extends MAVLinkMessage{

	public msg_gps_raw(){ messageType = MAVLINK_MSG_ID_GPS_RAW; }

	public static final int MAVLINK_MSG_ID_GPS_RAW = 32;

	private static final long serialVersionUID = MAVLINK_MSG_ID_GPS_RAW;

	public long usec; ///< Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	public int fix_type; ///< 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix.
	public float lat; ///< Latitude in degrees
	public float lon; ///< Longitude in degrees
	public float alt; ///< Altitude in meters
	public float eph; ///< GPS HDOP
	public float epv; ///< GPS VDOP
	public float v; ///< GPS ground speed
	public float hdg; ///< Compass heading in degrees, 0..360 degrees

}
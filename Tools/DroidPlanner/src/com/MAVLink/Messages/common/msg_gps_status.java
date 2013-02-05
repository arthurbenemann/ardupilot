package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_gps_status extends MAVLinkMessage{

	public msg_gps_status(){ messageType = MAVLINK_MSG_ID_GPS_STATUS; }

	public static final int MAVLINK_MSG_ID_GPS_STATUS = 25;

	private static final long serialVersionUID = MAVLINK_MSG_ID_GPS_STATUS;

	public int satellites_visible; ///< Number of satellites visible
	public 	int[] satellite_prn = new int[20];///< Global satellite ID
	public 	int[] satellite_used = new int[20];///< 0: Satellite not used, 1: used for localization
	public 	int[] satellite_elevation = new int[20];///< Elevation (0: right on top of receiver, 90: on the horizon) of satellite
	public 	int[] satellite_azimuth = new int[20];///< Direction of satellite, 0: 0 deg, 255: 360 deg.
	public 	int[] satellite_snr = new int[20];///< Signal to noise ratio of satellite

}
// MESSAGE GPS_GLOBAL_ORIGIN PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Once the MAV sets a new GPS-Local correspondence, this message announces the origin (0,0,0) position
*/
public class msg_gps_global_origin extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GPS_GLOBAL_ORIGIN = 49;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*Latitude (WGS84), expressed as * 1E7
	*/
	public int latitude; 
 	/**
	*Longitude (WGS84), expressed as * 1E7
	*/
	public int longitude; 
 	/**
	*Altitude(WGS84), expressed as * 1000
	*/
	public int altitude; 

/**
 * Decode a gps_global_origin message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.latitude = payload.getint();
	//m.longitude = payload.getint();
	//m.altitude = payload.getint();
    
    }
}

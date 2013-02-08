// MESSAGE SET_GPS_GLOBAL_ORIGIN PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* As local waypoints exist, the global MISSION reference allows to transform between the local coordinate frame and the global (GPS) coordinate frame. This can be necessary when e.g. in- and outdoor settings are connected and the MAV should move from in- to outdoor.
*/
public class msg_set_gps_global_origin extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN = 48;
	public static final int MAVLINK_MSG_LENGTH = 13;

 	/**
	*global position * 1E7
	*/
	public int latitude; 
 	/**
	*global position * 1E7
	*/
	public int longitude; 
 	/**
	*global position * 1000
	*/
	public int altitude; 
 	/**
	*System ID
	*/
	public byte target_system; 

/**
 * Decode a set_gps_global_origin message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.latitude = payload.getint();
	//m.longitude = payload.getint();
	//m.altitude = payload.getint();
	//m.target_system = payload.getbyte();
    
    }
}

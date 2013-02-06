// MESSAGE SET_GPS_GLOBAL_ORIGIN PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_set_gps_global_origin m = new msg_set_gps_global_origin();
	//m.latitude = _get_latitude(msg);
	//m.longitude = _get_longitude(msg);
	//m.altitude = _get_altitude(msg);
	//m.target_system = _get_target_system(msg);
    return m;	

    }
}

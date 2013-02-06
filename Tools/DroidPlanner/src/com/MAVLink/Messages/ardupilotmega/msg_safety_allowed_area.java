// MESSAGE SAFETY_ALLOWED_AREA PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Read out the safety zone the MAV currently assumes.
*/
public class msg_safety_allowed_area extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SAFETY_ALLOWED_AREA = 55;
	public static final int MAVLINK_MSG_LENGTH = 25;

 	/**
	*x position 1 / Latitude 1
	*/
	public float p1x; 
 	/**
	*y position 1 / Longitude 1
	*/
	public float p1y; 
 	/**
	*z position 1 / Altitude 1
	*/
	public float p1z; 
 	/**
	*x position 2 / Latitude 2
	*/
	public float p2x; 
 	/**
	*y position 2 / Longitude 2
	*/
	public float p2y; 
 	/**
	*z position 2 / Altitude 2
	*/
	public float p2z; 
 	/**
	*Coordinate frame, as defined by MAV_FRAME enum in mavlink_types.h. Can be either global, GPS, right-handed with Z axis up or local, right handed, Z axis down.
	*/
	public byte frame; 


/**
 * Decode a safety_allowed_area message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_safety_allowed_area m = new msg_safety_allowed_area();
	//m.p1x = _get_p1x(msg);
	//m.p1y = _get_p1y(msg);
	//m.p1z = _get_p1z(msg);
	//m.p2x = _get_p2x(msg);
	//m.p2y = _get_p2y(msg);
	//m.p2z = _get_p2z(msg);
	//m.frame = _get_frame(msg);
    return m;	

    }
}

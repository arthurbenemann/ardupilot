// MESSAGE GLOBAL_VISION_POSITION_ESTIMATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* 
*/
public class msg_global_vision_position_estimate extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE = 101;
	public static final int MAVLINK_MSG_LENGTH = 32;

 	/**
	*Timestamp (microseconds, synced to UNIX time or since system boot)
	*/
	public long usec; 
 	/**
	*Global X position
	*/
	public float x; 
 	/**
	*Global Y position
	*/
	public float y; 
 	/**
	*Global Z position
	*/
	public float z; 
 	/**
	*Roll angle in rad
	*/
	public float roll; 
 	/**
	*Pitch angle in rad
	*/
	public float pitch; 
 	/**
	*Yaw angle in rad
	*/
	public float yaw; 

/**
 * Decode a global_vision_position_estimate message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_global_vision_position_estimate m = new msg_global_vision_position_estimate();
	//m.usec = _get_usec(msg);
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
    return m;	

    }
}

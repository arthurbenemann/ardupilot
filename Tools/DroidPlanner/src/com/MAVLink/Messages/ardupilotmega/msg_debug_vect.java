// MESSAGE DEBUG_VECT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* 
*/
public class msg_debug_vect extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DEBUG_VECT = 250;
	public static final int MAVLINK_MSG_LENGTH = 30;

 	/**
	*Timestamp
	*/
	public long time_usec; 
 	/**
	*x
	*/
	public float x; 
 	/**
	*y
	*/
	public float y; 
 	/**
	*z
	*/
	public float z; 
 	/**
	*Name
	*/
	public byte name[] = new byte[10]; 

/**
 * Decode a debug_vect message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_debug_vect m = new msg_debug_vect();
	//m.time_usec = _get_time_usec(msg);
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	// = _get_name(msgm.name);
    return m;	

    }
}

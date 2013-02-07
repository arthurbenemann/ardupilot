// MESSAGE DEBUG PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Send a debug value. The index is used to discriminate between values. These values show up in the plot of QGroundControl as DEBUG N.
*/
public class msg_debug extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DEBUG = 254;
	public static final int MAVLINK_MSG_LENGTH = 9;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*DEBUG value
	*/
	public float value; 
 	/**
	*index of debug variable
	*/
	public byte ind; 

/**
 * Decode a debug message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_debug m = new msg_debug();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.value = _get_value(msg);
	//m.ind = _get_ind(msg);
    return m;	

    }
}

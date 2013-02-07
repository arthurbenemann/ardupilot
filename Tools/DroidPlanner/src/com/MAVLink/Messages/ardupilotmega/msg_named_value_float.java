// MESSAGE NAMED_VALUE_FLOAT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Send a key-value pair as float. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.
*/
public class msg_named_value_float extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT = 251;
	public static final int MAVLINK_MSG_LENGTH = 18;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*Floating point value
	*/
	public float value; 
 	/**
	*Name of the debug variable
	*/
	public byte name[] = new byte[10]; 

/**
 * Decode a named_value_float message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_named_value_float m = new msg_named_value_float();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.value = _get_value(msg);
	// = _get_name(msgm.name);
    return m;	

    }
}

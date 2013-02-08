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
public void unpack() {
	//m.time_boot_ms = payload.getint();
	//m.value = payload.getfloat();
	// = payload.getbyte();
    
    }
}

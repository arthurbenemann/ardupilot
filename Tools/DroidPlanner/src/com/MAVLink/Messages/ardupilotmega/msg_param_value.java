// MESSAGE PARAM_VALUE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Emit the value of a onboard parameter. The inclusion of param_count and param_index in the message allows the recipient to keep track of received parameters and allows him to re-request missing parameters after a loss or timeout.
*/
public class msg_param_value extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PARAM_VALUE = 22;
	public static final int MAVLINK_MSG_LENGTH = 25;

 	/**
	*Onboard parameter value
	*/
	public float param_value; 
 	/**
	*Total number of onboard parameters
	*/
	public short param_count; 
 	/**
	*Index of this onboard parameter
	*/
	public short param_index; 
 	/**
	*Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string
	*/
	public byte param_id[] = new byte[16]; 
 	/**
	*Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types.
	*/
	public byte param_type; 

/**
 * Decode a param_value message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.param_value = payload.getfloat();
	//m.param_count = payload.getshort();
	//m.param_index = payload.getshort();
	// = payload.getbyte();
	//m.param_type = payload.getbyte();
    
    }
}

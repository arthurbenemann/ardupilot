// MESSAGE DATA64 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Data packet, size 64
*/
public class msg_data64 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA64 = 171;
	public static final int MAVLINK_MSG_LENGTH = 66;

 	/**
	*data type
	*/
	public byte type; 
 	/**
	*data length
	*/
	public byte len; 
 	/**
	*raw data
	*/
	public byte data[] = new byte[64]; 

/**
 * Decode a data64 message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_data64 m = new msg_data64();
	//m.type = _get_type(msg);
	//m.len = _get_len(msg);
	// = _get_data(msgm.data);
    return m;	

    }
}

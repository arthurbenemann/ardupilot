// MESSAGE DATA16 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Data packet, size 16
*/
public class msg_data16 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA16 = 169;
	public static final int MAVLINK_MSG_LENGTH = 18;

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
	public byte data[] = new byte[16]; 

/**
 * Decode a data16 message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_data16 m = new msg_data16();
	//m.type = _get_type(msg);
	//m.len = _get_len(msg);
	// = _get_data(msgm.data);
    return m;	

    }
}

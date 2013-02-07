// MESSAGE DATA96 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Data packet, size 96
*/
public class msg_data96 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA96 = 172;
	public static final int MAVLINK_MSG_LENGTH = 98;

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
	public byte data[] = new byte[96]; 

/**
 * Decode a data96 message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_data96 m = new msg_data96();
	//m.type = _get_type(msg);
	//m.len = _get_len(msg);
	// = _get_data(msgm.data);
    return m;	

    }
}

// MESSAGE DATA_STREAM PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* 
*/
public class msg_data_stream extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA_STREAM = 67;
	public static final int MAVLINK_MSG_LENGTH = 4;

 	/**
	*The requested interval between two messages of this type
	*/
	public short message_rate; 
 	/**
	*The ID of the requested data stream
	*/
	public byte stream_id; 
 	/**
	*1 stream is enabled, 0 stream is stopped.
	*/
	public byte on_off; 

/**
 * Decode a data_stream message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.message_rate = payload.getshort();
	//m.stream_id = payload.getbyte();
	//m.on_off = payload.getbyte();
    
    }
}

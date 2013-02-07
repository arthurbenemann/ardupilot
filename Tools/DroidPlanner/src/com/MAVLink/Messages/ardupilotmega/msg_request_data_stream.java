// MESSAGE REQUEST_DATA_STREAM PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* 
*/
public class msg_request_data_stream extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_REQUEST_DATA_STREAM = 66;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*The requested interval between two messages of this type
	*/
	public short req_message_rate; 
 	/**
	*The target requested to send the message stream.
	*/
	public byte target_system; 
 	/**
	*The target requested to send the message stream.
	*/
	public byte target_component; 
 	/**
	*The ID of the requested data stream
	*/
	public byte req_stream_id; 
 	/**
	*1 to start sending, 0 to stop sending.
	*/
	public byte start_stop; 

/**
 * Decode a request_data_stream message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_request_data_stream m = new msg_request_data_stream();
	//m.req_message_rate = _get_req_message_rate(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.req_stream_id = _get_req_stream_id(msg);
	//m.start_stop = _get_start_stop(msg);
    return m;	

    }
}

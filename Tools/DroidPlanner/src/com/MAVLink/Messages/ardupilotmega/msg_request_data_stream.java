// MESSAGE REQUEST_DATA_STREAM PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    req_message_rate = payload.getShort();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    req_stream_id = payload.getByte();
	    start_stop = payload.getByte();    
    }

    public msg_request_data_stream(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_REQUEST_DATA_STREAM;
        unpack(payload);
        Log.d("MAVLink", "REQUEST_DATA_STREAM");
    }
}

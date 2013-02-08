// MESSAGE PARAM_REQUEST_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Request all parameters of this component. After his request, all parameters are emitted.
*/
public class msg_param_request_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PARAM_REQUEST_LIST = 21;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a param_request_list message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_param_request_list(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_PARAM_REQUEST_LIST;
        unpack(payload);
        Log.d("MAVLink", "PARAM_REQUEST_LIST");
    }
}

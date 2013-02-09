// MESSAGE MISSION_REQUEST_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Request the overall list of mission items from the system/component.
*/
public class msg_mission_request_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_REQUEST_LIST = 43;
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
 * Decode a mission_request_list message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_mission_request_list(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_REQUEST_LIST;
        unpack(payload);
        Log.d("MAVLink", "MISSION_REQUEST_LIST");
        //Log.d("MAVLINK_MSG_ID_MISSION_REQUEST_LIST", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_MISSION_REQUEST_LIST -"+" target_system:"+target_system+" target_component:"+target_component+"";
    }
}

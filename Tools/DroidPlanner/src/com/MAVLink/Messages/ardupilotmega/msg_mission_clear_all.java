// MESSAGE MISSION_CLEAR_ALL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Delete all mission items at once.
*/
public class msg_mission_clear_all extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_CLEAR_ALL = 45;
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
 * Decode a mission_clear_all message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_mission_clear_all(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_CLEAR_ALL;
        unpack(payload);
        Log.d("MAVLink", "MISSION_CLEAR_ALL");
    }
}

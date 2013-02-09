// MESSAGE MISSION_ITEM_REACHED PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* A certain mission item has been reached. The system will either hold this position (or circle on the orbit) or (if the autocontinue on the WP was set) continue to the next MISSION.
*/
public class msg_mission_item_reached extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_ITEM_REACHED = 46;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*Sequence
	*/
	public short seq; 

/**
 * Decode a mission_item_reached message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    seq = payload.getShort();    
    }

    public msg_mission_item_reached(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_ITEM_REACHED;
        unpack(payload);
        Log.d("MAVLink", "MISSION_ITEM_REACHED");
        //Log.d("MAVLINK_MSG_ID_MISSION_ITEM_REACHED", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_MISSION_ITEM_REACHED -"+" seq:"+seq+"";
    }
}

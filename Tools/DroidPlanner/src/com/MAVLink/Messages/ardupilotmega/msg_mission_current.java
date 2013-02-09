// MESSAGE MISSION_CURRENT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Message that announces the sequence number of the current active mission item. The MAV will fly towards this mission item.
*/
public class msg_mission_current extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_CURRENT = 42;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*Sequence
	*/
	public short seq; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_MISSION_CURRENT;
		packet.payload.putShort(seq);
		return packet;		
	}

    /**
     * Decode a mission_current message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    seq = payload.getShort();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_mission_current(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_CURRENT;
        unpack(payload);
        Log.d("MAVLink", "MISSION_CURRENT");
        //Log.d("MAVLINK_MSG_ID_MISSION_CURRENT", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_MISSION_CURRENT -"+" seq:"+seq+"";
    }
}

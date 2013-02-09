// MESSAGE MISSION_CLEAR_ALL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
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
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_MISSION_CLEAR_ALL;
		packet.payload.putByte(target_system);
		packet.payload.putByte(target_component);
		return packet;		
	}

    /**
     * Decode a mission_clear_all message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_mission_clear_all(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_CLEAR_ALL;
        unpack(payload);
        Log.d("MAVLink", "MISSION_CLEAR_ALL");
        //Log.d("MAVLINK_MSG_ID_MISSION_CLEAR_ALL", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_MISSION_CLEAR_ALL -"+" target_system:"+target_system+" target_component:"+target_component+"";
    }
}

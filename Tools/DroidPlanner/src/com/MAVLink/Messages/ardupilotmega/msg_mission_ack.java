// MESSAGE MISSION_ACK PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Ack message during MISSION handling. The type field states if this message is a positive ack (type=0) or if an error happened (type=non-zero).
*/
public class msg_mission_ack extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_ACK = 47;
	public static final int MAVLINK_MSG_LENGTH = 3;

 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*See MAV_MISSION_RESULT enum
	*/
	public byte type; 

/**
 * Decode a mission_ack message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//target_system = payload.getByte();
	//target_component = payload.getByte();
	//type = payload.getByte();
    
    }

    public msg_mission_ack(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_MISSION_ACK;
    unpack(payload);
    Log.d("MAVLink", "MISSION_ACK");
    }
}

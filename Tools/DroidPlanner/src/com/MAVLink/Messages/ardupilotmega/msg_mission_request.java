// MESSAGE MISSION_REQUEST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Request the information of the mission item with the sequence number seq. The response of the system to this message should be a MISSION_ITEM message. http://qgroundcontrol.org/mavlink/waypoint_protocol
*/
public class msg_mission_request extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_REQUEST = 40;
	public static final int MAVLINK_MSG_LENGTH = 4;

 	/**
	*Sequence
	*/
	public short seq; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a mission_request message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    seq = payload.getShort();
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_mission_request(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_REQUEST;
        unpack(payload);
        Log.d("MAVLink", "MISSION_REQUEST");
    }
}

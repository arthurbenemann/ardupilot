// MESSAGE MISSION_COUNT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write transaction. The GCS can then request the individual mission item based on the knowledge of the total number of MISSIONs.
*/
public class msg_mission_count extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_COUNT = 44;
	public static final int MAVLINK_MSG_LENGTH = 4;

 	/**
	*Number of mission items in the sequence
	*/
	public short count; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a mission_count message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    count = payload.getShort();
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_mission_count(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MISSION_COUNT;
        unpack(payload);
        Log.d("MAVLink", "MISSION_COUNT");
    }
}

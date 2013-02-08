// MESSAGE MISSION_WRITE_PARTIAL_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* This message is sent to the MAV to write a partial list. If start index == end index, only one item will be transmitted / updated. If the start index is NOT 0 and above the current list size, this request should be REJECTED!
*/
public class msg_mission_write_partial_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST = 38;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*Start index, 0 by default and smaller / equal to the largest index of the current onboard list.
	*/
	public short start_index; 
 	/**
	*End index, equal or greater than start index.
	*/
	public short end_index; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a mission_write_partial_list message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//start_index = payload.getShort();
	//end_index = payload.getShort();
	//target_system = payload.getByte();
	//target_component = payload.getByte();
    
    }

    public msg_mission_write_partial_list(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST;
    unpack(payload);
    Log.d("MAVLink", "MISSION_WRITE_PARTIAL_LIST");
    }
}

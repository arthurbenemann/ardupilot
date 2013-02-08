// MESSAGE MISSION_SET_CURRENT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set the mission item with sequence number seq as current item. This means that the MAV will continue to this mission item on the shortest path (not following the mission items in-between).
*/
public class msg_mission_set_current extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_SET_CURRENT = 41;
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
 * Decode a mission_set_current message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.seq = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }
}

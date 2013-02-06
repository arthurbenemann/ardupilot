// MESSAGE MISSION_SET_CURRENT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mission_set_current m = new msg_mission_set_current();
	//m.seq = _get_seq(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

// MESSAGE MISSION_REQUEST PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mission_request m = new msg_mission_request();
	//m.seq = _get_seq(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

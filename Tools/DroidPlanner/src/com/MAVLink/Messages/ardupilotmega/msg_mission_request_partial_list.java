// MESSAGE MISSION_REQUEST_PARTIAL_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Request a partial list of mission items from the system/component. http://qgroundcontrol.org/mavlink/waypoint_protocol. If start and end index are the same, just send one waypoint.
*/
public class msg_mission_request_partial_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST = 37;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*Start index, 0 by default
	*/
	public short start_index; 
 	/**
	*End index, -1 by default (-1: send list to end). Else a valid index of the list
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
 * Decode a mission_request_partial_list message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_mission_request_partial_list m = new msg_mission_request_partial_list();
	//m.start_index = _get_start_index(msg);
	//m.end_index = _get_end_index(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

// MESSAGE MISSION_WRITE_PARTIAL_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mission_write_partial_list m = new msg_mission_write_partial_list();
	//m.start_index = _get_start_index(msg);
	//m.end_index = _get_end_index(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

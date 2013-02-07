// MESSAGE MISSION_CLEAR_ALL PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
 * Decode a mission_clear_all message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mission_clear_all m = new msg_mission_clear_all();
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

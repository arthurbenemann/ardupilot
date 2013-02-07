// MESSAGE MISSION_ACK PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_mission_ack m = new msg_mission_ack();
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.type = _get_type(msg);
    return m;	

    }
}

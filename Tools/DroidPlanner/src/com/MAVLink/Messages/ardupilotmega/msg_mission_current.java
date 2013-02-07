// MESSAGE MISSION_CURRENT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Message that announces the sequence number of the current active mission item. The MAV will fly towards this mission item.
*/
public class msg_mission_current extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_CURRENT = 42;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*Sequence
	*/
	public short seq; 

/**
 * Decode a mission_current message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_mission_current m = new msg_mission_current();
	//m.seq = _get_seq(msg);
    return m;	

    }
}

// MESSAGE MISSION_ITEM_REACHED PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* A certain mission item has been reached. The system will either hold this position (or circle on the orbit) or (if the autocontinue on the WP was set) continue to the next MISSION.
*/
public class msg_mission_item_reached extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_ITEM_REACHED = 46;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*Sequence
	*/
	public short seq; 

/**
 * Decode a mission_item_reached message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mission_item_reached m = new msg_mission_item_reached();
	//m.seq = _get_seq(msg);
    return m;	

    }
}

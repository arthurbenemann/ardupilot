// MESSAGE FENCE_FETCH_POINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Request a current fence point from MAV
*/
public class msg_fence_fetch_point extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_FENCE_FETCH_POINT = 161;
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
	*point index (first point is 1, 0 is for return point)
	*/
	public byte idx; 

/**
 * Decode a fence_fetch_point message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_fence_fetch_point m = new msg_fence_fetch_point();
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.idx = _get_idx(msg);
    return m;	

    }
}

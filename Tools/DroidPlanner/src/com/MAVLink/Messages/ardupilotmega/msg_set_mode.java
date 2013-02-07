// MESSAGE SET_MODE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is by definition for the overall aircraft, not only for one component.
*/
public class msg_set_mode extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_MODE = 11;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*The new autopilot-specific mode. This field can be ignored by an autopilot.
	*/
	public int custom_mode; 
 	/**
	*The system setting the mode
	*/
	public byte target_system; 
 	/**
	*The new base mode
	*/
	public byte base_mode; 

/**
 * Decode a set_mode message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_set_mode m = new msg_set_mode();
	//m.custom_mode = _get_custom_mode(msg);
	//m.target_system = _get_target_system(msg);
	//m.base_mode = _get_base_mode(msg);
    return m;	

    }
}

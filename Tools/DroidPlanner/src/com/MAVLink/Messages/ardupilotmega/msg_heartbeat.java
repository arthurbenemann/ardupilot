// MESSAGE HEARTBEAT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* The heartbeat message shows that a system is present and responding. The type of the MAV and Autopilot hardware allow the receiving system to treat further messages from this system appropriate (e.g. by laying out the user interface based on the autopilot).
*/
public class msg_heartbeat extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HEARTBEAT = 0;
	public static final int MAVLINK_MSG_LENGTH = 9;

 	/**
	*A bitfield for use for autopilot-specific flags.
	*/
	public int custom_mode; 
 	/**
	*Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM)
	*/
	public byte type; 
 	/**
	*Autopilot type / class. defined in MAV_AUTOPILOT ENUM
	*/
	public byte autopilot; 
 	/**
	*System mode bitfield, see MAV_MODE_FLAGS ENUM in mavlink/include/mavlink_types.h
	*/
	public byte base_mode; 
 	/**
	*System status flag, see MAV_STATE ENUM
	*/
	public byte system_status; 
 	/**
	*MAVLink version, not writable by user, gets added by protocol because of magic data type: uint8_t_mavlink_version
	*/
	public byte mavlink_version; 

/**
 * Decode a heartbeat message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.custom_mode = payload.getint();
	//m.type = payload.getbyte();
	//m.autopilot = payload.getbyte();
	//m.base_mode = payload.getbyte();
	//m.system_status = payload.getbyte();
	//m.mavlink_version = payload.getbyte();
    
    }
}

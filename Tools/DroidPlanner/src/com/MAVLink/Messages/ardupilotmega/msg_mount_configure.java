// MESSAGE MOUNT_CONFIGURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Message to configure a camera mount, directional antenna, etc.
*/
public class msg_mount_configure extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MOUNT_CONFIGURE = 156;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*mount operating mode (see MAV_MOUNT_MODE enum)
	*/
	public byte mount_mode; 
 	/**
	*(1 = yes, 0 = no)
	*/
	public byte stab_roll; 
 	/**
	*(1 = yes, 0 = no)
	*/
	public byte stab_pitch; 
 	/**
	*(1 = yes, 0 = no)
	*/
	public byte stab_yaw; 

/**
 * Decode a mount_configure message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_mount_configure m = new msg_mount_configure();
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.mount_mode = _get_mount_mode(msg);
	//m.stab_roll = _get_stab_roll(msg);
	//m.stab_pitch = _get_stab_pitch(msg);
	//m.stab_yaw = _get_stab_yaw(msg);
    return m;	

    }
}

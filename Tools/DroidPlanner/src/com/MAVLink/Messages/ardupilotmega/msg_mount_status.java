// MESSAGE MOUNT_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Message with some status from APM to GCS about camera or antenna mount
*/
public class msg_mount_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MOUNT_STATUS = 158;
	public static final int MAVLINK_MSG_LENGTH = 14;

 	/**
	*pitch(deg*100) or lat, depending on mount mode
	*/
	public int pointing_a; 
 	/**
	*roll(deg*100) or lon depending on mount mode
	*/
	public int pointing_b; 
 	/**
	*yaw(deg*100) or alt (in cm) depending on mount mode
	*/
	public int pointing_c; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 


/**
 * Decode a mount_status message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mount_status m = new msg_mount_status();
	//m.pointing_a = _get_pointing_a(msg);
	//m.pointing_b = _get_pointing_b(msg);
	//m.pointing_c = _get_pointing_c(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

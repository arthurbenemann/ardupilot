// MESSAGE MOUNT_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Message to control a camera mount, directional antenna, etc.
*/
public class msg_mount_control extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MOUNT_CONTROL = 157;
	public static final int MAVLINK_MSG_LENGTH = 15;

 	/**
	*pitch(deg*100) or lat, depending on mount mode
	*/
	public int input_a; 
 	/**
	*roll(deg*100) or lon depending on mount mode
	*/
	public int input_b; 
 	/**
	*yaw(deg*100) or alt (in cm) depending on mount mode
	*/
	public int input_c; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING)
	*/
	public byte save_position; 

/**
 * Decode a mount_control message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_mount_control m = new msg_mount_control();
	//m.input_a = _get_input_a(msg);
	//m.input_b = _get_input_b(msg);
	//m.input_c = _get_input_c(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.save_position = _get_save_position(msg);
    return m;	

    }
}

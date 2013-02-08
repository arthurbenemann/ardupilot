// MESSAGE MOUNT_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.input_a = payload.getint();
	//m.input_b = payload.getint();
	//m.input_c = payload.getint();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
	//m.save_position = payload.getbyte();
    
    }
}

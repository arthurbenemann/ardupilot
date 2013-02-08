// MESSAGE MOUNT_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.pointing_a = payload.getint();
	//m.pointing_b = payload.getint();
	//m.pointing_c = payload.getint();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }
}

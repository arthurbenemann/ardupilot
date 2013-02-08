// MESSAGE SET_ROLL_PITCH_YAW_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set roll, pitch and yaw.
*/
public class msg_set_roll_pitch_yaw_thrust extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_THRUST = 56;
	public static final int MAVLINK_MSG_LENGTH = 18;

 	/**
	*Desired roll angle in radians
	*/
	public float roll; 
 	/**
	*Desired pitch angle in radians
	*/
	public float pitch; 
 	/**
	*Desired yaw angle in radians
	*/
	public float yaw; 
 	/**
	*Collective thrust, normalized to 0 .. 1
	*/
	public float thrust; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a set_roll_pitch_yaw_thrust message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.roll = payload.getfloat();
	//m.pitch = payload.getfloat();
	//m.yaw = payload.getfloat();
	//m.thrust = payload.getfloat();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }
}

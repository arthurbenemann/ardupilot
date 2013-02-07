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
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_set_roll_pitch_yaw_thrust m = new msg_set_roll_pitch_yaw_thrust();
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
	//m.thrust = _get_thrust(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

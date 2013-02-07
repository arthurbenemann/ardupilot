// MESSAGE SET_ROLL_PITCH_YAW_SPEED_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set roll, pitch and yaw.
*/
public class msg_set_roll_pitch_yaw_speed_thrust extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST = 57;
	public static final int MAVLINK_MSG_LENGTH = 18;

 	/**
	*Desired roll angular speed in rad/s
	*/
	public float roll_speed; 
 	/**
	*Desired pitch angular speed in rad/s
	*/
	public float pitch_speed; 
 	/**
	*Desired yaw angular speed in rad/s
	*/
	public float yaw_speed; 
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
 * Decode a set_roll_pitch_yaw_speed_thrust message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_set_roll_pitch_yaw_speed_thrust m = new msg_set_roll_pitch_yaw_speed_thrust();
	//m.roll_speed = _get_roll_speed(msg);
	//m.pitch_speed = _get_pitch_speed(msg);
	//m.yaw_speed = _get_yaw_speed(msg);
	//m.thrust = _get_thrust(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

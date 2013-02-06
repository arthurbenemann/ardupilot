// MESSAGE ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Setpoint in rollspeed, pitchspeed, yawspeed currently active on the system.
*/
public class msg_roll_pitch_yaw_speed_thrust_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT = 59;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
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
 * Decode a roll_pitch_yaw_speed_thrust_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_roll_pitch_yaw_speed_thrust_setpoint m = new msg_roll_pitch_yaw_speed_thrust_setpoint();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.roll_speed = _get_roll_speed(msg);
	//m.pitch_speed = _get_pitch_speed(msg);
	//m.yaw_speed = _get_yaw_speed(msg);
	//m.thrust = _get_thrust(msg);
    return m;	

    }
}

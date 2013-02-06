// MESSAGE ROLL_PITCH_YAW_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Setpoint in roll, pitch, yaw currently active on the system.
*/
public class msg_roll_pitch_yaw_thrust_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_THRUST_SETPOINT = 58;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
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
 * Decode a roll_pitch_yaw_thrust_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_roll_pitch_yaw_thrust_setpoint m = new msg_roll_pitch_yaw_thrust_setpoint();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
	//m.thrust = _get_thrust(msg);
    return m;	

    }
}

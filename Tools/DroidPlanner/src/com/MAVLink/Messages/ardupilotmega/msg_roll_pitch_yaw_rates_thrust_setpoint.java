// MESSAGE ROLL_PITCH_YAW_RATES_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Setpoint in roll, pitch, yaw rates and thrust currently active on the system.
*/
public class msg_roll_pitch_yaw_rates_thrust_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT = 80;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
 	/**
	*Desired roll rate in radians per second
	*/
	public float roll_rate; 
 	/**
	*Desired pitch rate in radians per second
	*/
	public float pitch_rate; 
 	/**
	*Desired yaw rate in radians per second
	*/
	public float yaw_rate; 
 	/**
	*Collective thrust, normalized to 0 .. 1
	*/
	public float thrust; 

/**
 * Decode a roll_pitch_yaw_rates_thrust_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_roll_pitch_yaw_rates_thrust_setpoint m = new msg_roll_pitch_yaw_rates_thrust_setpoint();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.roll_rate = _get_roll_rate(msg);
	//m.pitch_rate = _get_pitch_rate(msg);
	//m.yaw_rate = _get_yaw_rate(msg);
	//m.thrust = _get_thrust(msg);
    return m;	

    }
}

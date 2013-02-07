// MESSAGE MANUAL_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Setpoint in roll, pitch, yaw and thrust from the operator
*/
public class msg_manual_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MANUAL_SETPOINT = 81;
	public static final int MAVLINK_MSG_LENGTH = 22;

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
 	/**
	*Desired roll rate in radians per second
	*/
	public float roll; 
 	/**
	*Desired pitch rate in radians per second
	*/
	public float pitch; 
 	/**
	*Desired yaw rate in radians per second
	*/
	public float yaw; 
 	/**
	*Collective thrust, normalized to 0 .. 1
	*/
	public float thrust; 
 	/**
	*Flight mode switch position, 0.. 255
	*/
	public byte mode_switch; 
 	/**
	*Override mode switch position, 0.. 255
	*/
	public byte manual_override_switch; 

/**
 * Decode a manual_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_manual_setpoint m = new msg_manual_setpoint();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
	//m.thrust = _get_thrust(msg);
	//m.mode_switch = _get_mode_switch(msg);
	//m.manual_override_switch = _get_manual_override_switch(msg);
    return m;	

    }
}

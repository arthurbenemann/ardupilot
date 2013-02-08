// MESSAGE ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.time_boot_ms = payload.getint();
	//m.roll_speed = payload.getfloat();
	//m.pitch_speed = payload.getfloat();
	//m.yaw_speed = payload.getfloat();
	//m.thrust = payload.getfloat();
    
    }
}

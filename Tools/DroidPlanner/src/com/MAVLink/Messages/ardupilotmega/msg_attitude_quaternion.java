// MESSAGE ATTITUDE_QUATERNION PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion.
*/
public class msg_attitude_quaternion extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION = 31;
	public static final int MAVLINK_MSG_LENGTH = 32;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*Quaternion component 1
	*/
	public float q1; 
 	/**
	*Quaternion component 2
	*/
	public float q2; 
 	/**
	*Quaternion component 3
	*/
	public float q3; 
 	/**
	*Quaternion component 4
	*/
	public float q4; 
 	/**
	*Roll angular speed (rad/s)
	*/
	public float rollspeed; 
 	/**
	*Pitch angular speed (rad/s)
	*/
	public float pitchspeed; 
 	/**
	*Yaw angular speed (rad/s)
	*/
	public float yawspeed; 

/**
 * Decode a attitude_quaternion message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_attitude_quaternion m = new msg_attitude_quaternion();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.q1 = _get_q1(msg);
	//m.q2 = _get_q2(msg);
	//m.q3 = _get_q3(msg);
	//m.q4 = _get_q4(msg);
	//m.rollspeed = _get_rollspeed(msg);
	//m.pitchspeed = _get_pitchspeed(msg);
	//m.yawspeed = _get_yawspeed(msg);
    return m;	

    }
}

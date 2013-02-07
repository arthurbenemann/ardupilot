// MESSAGE ATTITUDE PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right).
*/
public class msg_attitude extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_ATTITUDE = 30;
	public static final int MAVLINK_MSG_LENGTH = 28;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*Roll angle (rad, -pi..+pi)
	*/
	public float roll; 
 	/**
	*Pitch angle (rad, -pi..+pi)
	*/
	public float pitch; 
 	/**
	*Yaw angle (rad, -pi..+pi)
	*/
	public float yaw; 
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
 * Decode a attitude message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_attitude m = new msg_attitude();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
	//m.rollspeed = _get_rollspeed(msg);
	//m.pitchspeed = _get_pitchspeed(msg);
	//m.yawspeed = _get_yawspeed(msg);
    return m;	

    }
}

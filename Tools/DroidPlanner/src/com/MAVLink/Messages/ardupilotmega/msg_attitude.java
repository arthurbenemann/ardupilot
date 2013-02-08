// MESSAGE ATTITUDE PACKING
package com.MAVLink.Messages.ardupilotmega;

import android.util.Log;

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
public void unpack() {
	time_boot_ms = payload.getInt();
	roll = payload.getFloat();
	pitch = payload.getFloat();
	yaw = payload.getFloat();
	rollspeed = payload.getFloat();
	pitchspeed = payload.getFloat();
	yawspeed = payload.getFloat();
    
	Log.d("ROLL",String.format("Roll: %5.5f \t Time: %d", roll, time_boot_ms));
    }
}

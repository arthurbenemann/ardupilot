// MESSAGE ATTITUDE_QUATERNION PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//m.time_boot_ms = payload.getint();
	//m.q1 = payload.getfloat();
	//m.q2 = payload.getfloat();
	//m.q3 = payload.getfloat();
	//m.q4 = payload.getfloat();
	//m.rollspeed = payload.getfloat();
	//m.pitchspeed = payload.getfloat();
	//m.yawspeed = payload.getfloat();
    
    }

    public msg_attitude_quaternion(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "ATTITUDE_QUATERNION");
	}
}

// MESSAGE ATTITUDE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//time_boot_ms = payload.getInt();
	//roll = payload.getFloat();
	//pitch = payload.getFloat();
	//yaw = payload.getFloat();
	//rollspeed = payload.getFloat();
	//pitchspeed = payload.getFloat();
	//yawspeed = payload.getFloat();
    
    }

    public msg_attitude(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_ATTITUDE;
    unpack(payload);
    Log.d("MAVLink", "ATTITUDE");
    }
}

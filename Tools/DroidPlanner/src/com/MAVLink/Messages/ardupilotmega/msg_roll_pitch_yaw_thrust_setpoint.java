// MESSAGE ROLL_PITCH_YAW_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//time_boot_ms = payload.getInt();
	//roll = payload.getFloat();
	//pitch = payload.getFloat();
	//yaw = payload.getFloat();
	//thrust = payload.getFloat();
    
    }

    public msg_roll_pitch_yaw_thrust_setpoint(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_ROLL_PITCH_YAW_THRUST_SETPOINT;
    unpack(payload);
    Log.d("MAVLink", "ROLL_PITCH_YAW_THRUST_SETPOINT");
    }
}

// MESSAGE SET_ROLL_PITCH_YAW_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Set roll, pitch and yaw.
*/
public class msg_set_roll_pitch_yaw_thrust extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_THRUST = 56;
	public static final int MAVLINK_MSG_LENGTH = 18;

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
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a set_roll_pitch_yaw_thrust message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//roll = payload.getFloat();
	//pitch = payload.getFloat();
	//yaw = payload.getFloat();
	//thrust = payload.getFloat();
	//target_system = payload.getByte();
	//target_component = payload.getByte();
    
    }

    public msg_set_roll_pitch_yaw_thrust(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_THRUST;
    unpack(payload);
    Log.d("MAVLink", "SET_ROLL_PITCH_YAW_THRUST");
    }
}

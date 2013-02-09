// MESSAGE SET_ROLL_PITCH_YAW_SPEED_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Set roll, pitch and yaw.
*/
public class msg_set_roll_pitch_yaw_speed_thrust extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST = 57;
	public static final int MAVLINK_MSG_LENGTH = 18;

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
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a set_roll_pitch_yaw_speed_thrust message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    roll_speed = payload.getFloat();
	    pitch_speed = payload.getFloat();
	    yaw_speed = payload.getFloat();
	    thrust = payload.getFloat();
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_set_roll_pitch_yaw_speed_thrust(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST;
        unpack(payload);
        Log.d("MAVLink", "SET_ROLL_PITCH_YAW_SPEED_THRUST");
        //Log.d("MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST -"+" roll_speed:"+roll_speed+" pitch_speed:"+pitch_speed+" yaw_speed:"+yaw_speed+" thrust:"+thrust+" target_system:"+target_system+" target_component:"+target_component+"";
    }
}

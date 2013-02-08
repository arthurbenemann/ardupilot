// MESSAGE ROLL_PITCH_YAW_RATES_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Setpoint in roll, pitch, yaw rates and thrust currently active on the system.
*/
public class msg_roll_pitch_yaw_rates_thrust_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT = 80;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
 	/**
	*Desired roll rate in radians per second
	*/
	public float roll_rate; 
 	/**
	*Desired pitch rate in radians per second
	*/
	public float pitch_rate; 
 	/**
	*Desired yaw rate in radians per second
	*/
	public float yaw_rate; 
 	/**
	*Collective thrust, normalized to 0 .. 1
	*/
	public float thrust; 

/**
 * Decode a roll_pitch_yaw_rates_thrust_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_boot_ms = payload.getInt();
	    roll_rate = payload.getFloat();
	    pitch_rate = payload.getFloat();
	    yaw_rate = payload.getFloat();
	    thrust = payload.getFloat();    
    }

    public msg_roll_pitch_yaw_rates_thrust_setpoint(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT;
        unpack(payload);
        Log.d("MAVLink", "ROLL_PITCH_YAW_RATES_THRUST_SETPOINT");
    }
}

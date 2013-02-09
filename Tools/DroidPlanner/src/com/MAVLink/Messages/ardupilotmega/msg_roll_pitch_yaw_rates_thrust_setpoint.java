// MESSAGE ROLL_PITCH_YAW_RATES_THRUST_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
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
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT;
		packet.payload.putInt(time_boot_ms);
		packet.payload.putFloat(roll_rate);
		packet.payload.putFloat(pitch_rate);
		packet.payload.putFloat(yaw_rate);
		packet.payload.putFloat(thrust);
		return packet;		
	}

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

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_roll_pitch_yaw_rates_thrust_setpoint(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT;
        unpack(payload);
        Log.d("MAVLink", "ROLL_PITCH_YAW_RATES_THRUST_SETPOINT");
        //Log.d("MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT -"+" time_boot_ms:"+time_boot_ms+" roll_rate:"+roll_rate+" pitch_rate:"+pitch_rate+" yaw_rate:"+yaw_rate+" thrust:"+thrust+"";
    }
}

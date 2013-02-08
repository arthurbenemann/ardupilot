// MESSAGE SERVO_OUTPUT_RAW PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%.
*/
public class msg_servo_output_raw extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SERVO_OUTPUT_RAW = 36;
	public static final int MAVLINK_MSG_LENGTH = 21;

 	/**
	*Timestamp (microseconds since system boot)
	*/
	public int time_usec; 
 	/**
	*Servo output 1 value, in microseconds
	*/
	public short servo1_raw; 
 	/**
	*Servo output 2 value, in microseconds
	*/
	public short servo2_raw; 
 	/**
	*Servo output 3 value, in microseconds
	*/
	public short servo3_raw; 
 	/**
	*Servo output 4 value, in microseconds
	*/
	public short servo4_raw; 
 	/**
	*Servo output 5 value, in microseconds
	*/
	public short servo5_raw; 
 	/**
	*Servo output 6 value, in microseconds
	*/
	public short servo6_raw; 
 	/**
	*Servo output 7 value, in microseconds
	*/
	public short servo7_raw; 
 	/**
	*Servo output 8 value, in microseconds
	*/
	public short servo8_raw; 
 	/**
	*Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows to encode more than 8 servos.
	*/
	public byte port; 

/**
 * Decode a servo_output_raw message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_usec = payload.getInt();
	    servo1_raw = payload.getShort();
	    servo2_raw = payload.getShort();
	    servo3_raw = payload.getShort();
	    servo4_raw = payload.getShort();
	    servo5_raw = payload.getShort();
	    servo6_raw = payload.getShort();
	    servo7_raw = payload.getShort();
	    servo8_raw = payload.getShort();
	    port = payload.getByte();    
    }

    public msg_servo_output_raw(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SERVO_OUTPUT_RAW;
        unpack(payload);
        Log.d("MAVLink", "SERVO_OUTPUT_RAW");
    }
}

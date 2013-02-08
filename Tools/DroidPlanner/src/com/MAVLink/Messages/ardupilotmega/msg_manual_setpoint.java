// MESSAGE MANUAL_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Setpoint in roll, pitch, yaw and thrust from the operator
*/
public class msg_manual_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MANUAL_SETPOINT = 81;
	public static final int MAVLINK_MSG_LENGTH = 22;

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
 	/**
	*Desired roll rate in radians per second
	*/
	public float roll; 
 	/**
	*Desired pitch rate in radians per second
	*/
	public float pitch; 
 	/**
	*Desired yaw rate in radians per second
	*/
	public float yaw; 
 	/**
	*Collective thrust, normalized to 0 .. 1
	*/
	public float thrust; 
 	/**
	*Flight mode switch position, 0.. 255
	*/
	public byte mode_switch; 
 	/**
	*Override mode switch position, 0.. 255
	*/
	public byte manual_override_switch; 

/**
 * Decode a manual_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.time_boot_ms = payload.getint();
	//m.roll = payload.getfloat();
	//m.pitch = payload.getfloat();
	//m.yaw = payload.getfloat();
	//m.thrust = payload.getfloat();
	//m.mode_switch = payload.getbyte();
	//m.manual_override_switch = payload.getbyte();
    
    }
}

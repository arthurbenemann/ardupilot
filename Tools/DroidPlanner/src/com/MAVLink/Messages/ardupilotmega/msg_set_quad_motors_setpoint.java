// MESSAGE SET_QUAD_MOTORS_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Setpoint in the four motor speeds
*/
public class msg_set_quad_motors_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_QUAD_MOTORS_SETPOINT = 60;
	public static final int MAVLINK_MSG_LENGTH = 9;

 	/**
	*Front motor in + configuration, front left motor in x configuration
	*/
	public short motor_front_nw; 
 	/**
	*Right motor in + configuration, front right motor in x configuration
	*/
	public short motor_right_ne; 
 	/**
	*Back motor in + configuration, back right motor in x configuration
	*/
	public short motor_back_se; 
 	/**
	*Left motor in + configuration, back left motor in x configuration
	*/
	public short motor_left_sw; 
 	/**
	*System ID of the system that should set these motor commands
	*/
	public byte target_system; 

/**
 * Decode a set_quad_motors_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.motor_front_nw = payload.getshort();
	//m.motor_right_ne = payload.getshort();
	//m.motor_back_se = payload.getshort();
	//m.motor_left_sw = payload.getshort();
	//m.target_system = payload.getbyte();
    
    }

    public msg_set_quad_motors_setpoint(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "SET_QUAD_MOTORS_SETPOINT");
	}
}

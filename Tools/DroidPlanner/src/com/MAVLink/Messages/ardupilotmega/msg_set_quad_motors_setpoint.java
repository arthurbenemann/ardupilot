// MESSAGE SET_QUAD_MOTORS_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_set_quad_motors_setpoint m = new msg_set_quad_motors_setpoint();
	//m.motor_front_nw = _get_motor_front_nw(msg);
	//m.motor_right_ne = _get_motor_right_ne(msg);
	//m.motor_back_se = _get_motor_back_se(msg);
	//m.motor_left_sw = _get_motor_left_sw(msg);
	//m.target_system = _get_target_system(msg);
    return m;	

    }
}

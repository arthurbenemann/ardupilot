// MESSAGE MANUAL_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* This message provides an API for manually controlling the vehicle using standard joystick axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an buttons are also transmit as boolean values of their 
*/
public class msg_manual_control extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MANUAL_CONTROL = 69;
	public static final int MAVLINK_MSG_LENGTH = 11;

 	/**
	*X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and the pitch of a vehicle.
	*/
	public short x; 
 	/**
	*Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the roll of a vehicle.
	*/
	public short y; 
 	/**
	*Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a separate slider movement with maximum being 1000 and minimum being -1000 on a joystick and the thrust of a vehicle.
	*/
	public short z; 
 	/**
	*R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 1000 and clockwise being -1000, and the yaw of a vehicle.
	*/
	public short r; 
 	/**
	*A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 1.
	*/
	public short buttons; 
 	/**
	*The system to be controlled.
	*/
	public byte target; 


/**
 * Decode a manual_control message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_manual_control m = new msg_manual_control();
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	//m.r = _get_r(msg);
	//m.buttons = _get_buttons(msg);
	//m.target = _get_target(msg);
    return m;	

    }
}

// MESSAGE SETPOINT_6DOF PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set the 6 DOF setpoint for a attitude and position controller.
*/
public class msg_setpoint_6dof extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SETPOINT_6DOF = 149;
	public static final int MAVLINK_MSG_LENGTH = 25;

 	/**
	*Translational Component in x
	*/
	public float trans_x; 
 	/**
	*Translational Component in y
	*/
	public float trans_y; 
 	/**
	*Translational Component in z
	*/
	public float trans_z; 
 	/**
	*Rotational Component in x
	*/
	public float rot_x; 
 	/**
	*Rotational Component in y
	*/
	public float rot_y; 
 	/**
	*Rotational Component in z
	*/
	public float rot_z; 
 	/**
	*System ID
	*/
	public byte target_system; 

/**
 * Decode a setpoint_6dof message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_setpoint_6dof m = new msg_setpoint_6dof();
	//m.trans_x = _get_trans_x(msg);
	//m.trans_y = _get_trans_y(msg);
	//m.trans_z = _get_trans_z(msg);
	//m.rot_x = _get_rot_x(msg);
	//m.rot_y = _get_rot_y(msg);
	//m.rot_z = _get_rot_z(msg);
	//m.target_system = _get_target_system(msg);
    return m;	

    }
}

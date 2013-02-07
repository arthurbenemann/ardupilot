// MESSAGE SETPOINT_8DOF PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set the 8 DOF setpoint for a controller.
*/
public class msg_setpoint_8dof extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SETPOINT_8DOF = 148;
	public static final int MAVLINK_MSG_LENGTH = 33;

 	/**
	*Value 1
	*/
	public float val1; 
 	/**
	*Value 2
	*/
	public float val2; 
 	/**
	*Value 3
	*/
	public float val3; 
 	/**
	*Value 4
	*/
	public float val4; 
 	/**
	*Value 5
	*/
	public float val5; 
 	/**
	*Value 6
	*/
	public float val6; 
 	/**
	*Value 7
	*/
	public float val7; 
 	/**
	*Value 8
	*/
	public float val8; 
 	/**
	*System ID
	*/
	public byte target_system; 

/**
 * Decode a setpoint_8dof message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_setpoint_8dof m = new msg_setpoint_8dof();
	//m.val1 = _get_val1(msg);
	//m.val2 = _get_val2(msg);
	//m.val3 = _get_val3(msg);
	//m.val4 = _get_val4(msg);
	//m.val5 = _get_val5(msg);
	//m.val6 = _get_val6(msg);
	//m.val7 = _get_val7(msg);
	//m.val8 = _get_val8(msg);
	//m.target_system = _get_target_system(msg);
    return m;	

    }
}

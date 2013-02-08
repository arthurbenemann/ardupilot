// MESSAGE SETPOINT_8DOF PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//m.val1 = payload.getfloat();
	//m.val2 = payload.getfloat();
	//m.val3 = payload.getfloat();
	//m.val4 = payload.getfloat();
	//m.val5 = payload.getfloat();
	//m.val6 = payload.getfloat();
	//m.val7 = payload.getfloat();
	//m.val8 = payload.getfloat();
	//m.target_system = payload.getbyte();
    
    }

    public msg_setpoint_8dof(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "SETPOINT_8DOF");
	}
}

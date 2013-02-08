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
	//val1 = payload.getFloat();
	//val2 = payload.getFloat();
	//val3 = payload.getFloat();
	//val4 = payload.getFloat();
	//val5 = payload.getFloat();
	//val6 = payload.getFloat();
	//val7 = payload.getFloat();
	//val8 = payload.getFloat();
	//target_system = payload.getByte();
    
    }

    public msg_setpoint_8dof(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_SETPOINT_8DOF;
    unpack(payload);
    Log.d("MAVLink", "SETPOINT_8DOF");
    }
}

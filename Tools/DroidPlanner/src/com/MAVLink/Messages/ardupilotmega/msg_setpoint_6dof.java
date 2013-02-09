// MESSAGE SETPOINT_6DOF PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    trans_x = payload.getFloat();
	    trans_y = payload.getFloat();
	    trans_z = payload.getFloat();
	    rot_x = payload.getFloat();
	    rot_y = payload.getFloat();
	    rot_z = payload.getFloat();
	    target_system = payload.getByte();    
    }

    public msg_setpoint_6dof(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SETPOINT_6DOF;
        unpack(payload);
        Log.d("MAVLink", "SETPOINT_6DOF");
        //Log.d("MAVLINK_MSG_ID_SETPOINT_6DOF", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_SETPOINT_6DOF -"+" trans_x:"+trans_x+" trans_y:"+trans_y+" trans_z:"+trans_z+" rot_x:"+rot_x+" rot_y:"+rot_y+" rot_z:"+rot_z+" target_system:"+target_system+"";
    }
}

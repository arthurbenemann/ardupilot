// MESSAGE LOCAL_POSITION_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Transmit the current local setpoint of the controller to other MAVs (collision avoidance) and to the GCS.
*/
public class msg_local_position_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT = 51;
	public static final int MAVLINK_MSG_LENGTH = 17;

 	/**
	*x position
	*/
	public float x; 
 	/**
	*y position
	*/
	public float y; 
 	/**
	*z position
	*/
	public float z; 
 	/**
	*Desired yaw angle
	*/
	public float yaw; 
 	/**
	*Coordinate frame - valid values are only MAV_FRAME_LOCAL_NED or MAV_FRAME_LOCAL_ENU
	*/
	public byte coordinate_frame; 

/**
 * Decode a local_position_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    x = payload.getFloat();
	    y = payload.getFloat();
	    z = payload.getFloat();
	    yaw = payload.getFloat();
	    coordinate_frame = payload.getByte();    
    }

    public msg_local_position_setpoint(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT;
        unpack(payload);
        Log.d("MAVLink", "LOCAL_POSITION_SETPOINT");
        //Log.d("MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT -"+" x:"+x+" y:"+y+" z:"+z+" yaw:"+yaw+" coordinate_frame:"+coordinate_frame+"";
    }
}

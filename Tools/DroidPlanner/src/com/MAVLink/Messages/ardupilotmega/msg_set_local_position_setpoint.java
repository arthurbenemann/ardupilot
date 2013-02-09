// MESSAGE SET_LOCAL_POSITION_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Set the setpoint for a local position controller. This is the position in local coordinates the MAV should fly to. This message is sent by the path/MISSION planner to the onboard position controller. As some MAVs have a degree of freedom in yaw (e.g. all helicopters/quadrotors), the desired yaw angle is part of the message.
*/
public class msg_set_local_position_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT = 50;
	public static final int MAVLINK_MSG_LENGTH = 19;

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
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*Coordinate frame - valid values are only MAV_FRAME_LOCAL_NED or MAV_FRAME_LOCAL_ENU
	*/
	public byte coordinate_frame; 

/**
 * Decode a set_local_position_setpoint message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    x = payload.getFloat();
	    y = payload.getFloat();
	    z = payload.getFloat();
	    yaw = payload.getFloat();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    coordinate_frame = payload.getByte();    
    }

    public msg_set_local_position_setpoint(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT;
        unpack(payload);
        Log.d("MAVLink", "SET_LOCAL_POSITION_SETPOINT");
        //Log.d("MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT -"+" x:"+x+" y:"+y+" z:"+z+" yaw:"+yaw+" target_system:"+target_system+" target_component:"+target_component+" coordinate_frame:"+coordinate_frame+"";
    }
}

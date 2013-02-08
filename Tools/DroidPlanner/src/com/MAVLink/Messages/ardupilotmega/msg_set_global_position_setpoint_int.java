// MESSAGE SET_GLOBAL_POSITION_SETPOINT_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Set the current global position setpoint.
*/
public class msg_set_global_position_setpoint_int extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_GLOBAL_POSITION_SETPOINT_INT = 53;
	public static final int MAVLINK_MSG_LENGTH = 15;

 	/**
	*WGS84 Latitude position in degrees * 1E7
	*/
	public int latitude; 
 	/**
	*WGS84 Longitude position in degrees * 1E7
	*/
	public int longitude; 
 	/**
	*WGS84 Altitude in meters * 1000 (positive for up)
	*/
	public int altitude; 
 	/**
	*Desired yaw angle in degrees * 100
	*/
	public short yaw; 
 	/**
	*Coordinate frame - valid values are only MAV_FRAME_GLOBAL or MAV_FRAME_GLOBAL_RELATIVE_ALT
	*/
	public byte coordinate_frame; 

/**
 * Decode a set_global_position_setpoint_int message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//latitude = payload.getInt();
	//longitude = payload.getInt();
	//altitude = payload.getInt();
	//yaw = payload.getShort();
	//coordinate_frame = payload.getByte();
    
    }

    public msg_set_global_position_setpoint_int(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_SET_GLOBAL_POSITION_SETPOINT_INT;
    unpack(payload);
    Log.d("MAVLink", "SET_GLOBAL_POSITION_SETPOINT_INT");
    }
}

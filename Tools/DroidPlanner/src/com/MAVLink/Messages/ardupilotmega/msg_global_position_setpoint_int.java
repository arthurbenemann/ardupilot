// MESSAGE GLOBAL_POSITION_SETPOINT_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Transmit the current local setpoint of the controller to other MAVs (collision avoidance) and to the GCS.
*/
public class msg_global_position_setpoint_int extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_SETPOINT_INT = 52;
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
 * Decode a global_position_setpoint_int message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.latitude = payload.getint();
	//m.longitude = payload.getint();
	//m.altitude = payload.getint();
	//m.yaw = payload.getshort();
	//m.coordinate_frame = payload.getbyte();
    
    }

    public msg_global_position_setpoint_int(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "GLOBAL_POSITION_SETPOINT_INT");
	}
}

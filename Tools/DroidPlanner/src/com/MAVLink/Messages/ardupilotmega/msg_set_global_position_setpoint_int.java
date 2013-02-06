// MESSAGE SET_GLOBAL_POSITION_SETPOINT_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_set_global_position_setpoint_int m = new msg_set_global_position_setpoint_int();
	//m.latitude = _get_latitude(msg);
	//m.longitude = _get_longitude(msg);
	//m.altitude = _get_altitude(msg);
	//m.yaw = _get_yaw(msg);
	//m.coordinate_frame = _get_coordinate_frame(msg);
    return m;	

    }
}

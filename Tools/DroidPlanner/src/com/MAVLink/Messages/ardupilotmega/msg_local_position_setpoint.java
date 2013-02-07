// MESSAGE LOCAL_POSITION_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_local_position_setpoint m = new msg_local_position_setpoint();
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	//m.yaw = _get_yaw(msg);
	//m.coordinate_frame = _get_coordinate_frame(msg);
    return m;	

    }
}

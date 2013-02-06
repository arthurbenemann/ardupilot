// MESSAGE SET_LOCAL_POSITION_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_set_local_position_setpoint m = new msg_set_local_position_setpoint();
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	//m.yaw = _get_yaw(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.coordinate_frame = _get_coordinate_frame(msg);
    return m;	

    }
}

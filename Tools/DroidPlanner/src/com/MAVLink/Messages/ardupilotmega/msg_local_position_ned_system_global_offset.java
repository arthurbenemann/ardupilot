// MESSAGE LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The offset in X, Y, Z and yaw between the LOCAL_POSITION_NED messages of MAV X and the global coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
*/
public class msg_local_position_ned_system_global_offset extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET = 89;
	public static final int MAVLINK_MSG_LENGTH = 28;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*X Position
	*/
	public float x; 
 	/**
	*Y Position
	*/
	public float y; 
 	/**
	*Z Position
	*/
	public float z; 
 	/**
	*Roll
	*/
	public float roll; 
 	/**
	*Pitch
	*/
	public float pitch; 
 	/**
	*Yaw
	*/
	public float yaw; 

/**
 * Decode a local_position_ned_system_global_offset message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_local_position_ned_system_global_offset m = new msg_local_position_ned_system_global_offset();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
    return m;	

    }
}

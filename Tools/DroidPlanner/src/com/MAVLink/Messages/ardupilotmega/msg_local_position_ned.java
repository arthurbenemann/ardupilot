// MESSAGE LOCAL_POSITION_NED PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
*/
public class msg_local_position_ned extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_LOCAL_POSITION_NED = 32;
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
	*X Speed
	*/
	public float vx; 
 	/**
	*Y Speed
	*/
	public float vy; 
 	/**
	*Z Speed
	*/
	public float vz; 

/**
 * Decode a local_position_ned message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_local_position_ned m = new msg_local_position_ned();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.x = _get_x(msg);
	//m.y = _get_y(msg);
	//m.z = _get_z(msg);
	//m.vx = _get_vx(msg);
	//m.vy = _get_vy(msg);
	//m.vz = _get_vz(msg);
    return m;	

    }
}

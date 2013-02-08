// MESSAGE LOCAL_POSITION_NED PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.time_boot_ms = payload.getint();
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
	//m.vx = payload.getfloat();
	//m.vy = payload.getfloat();
	//m.vz = payload.getfloat();
    
    }
}

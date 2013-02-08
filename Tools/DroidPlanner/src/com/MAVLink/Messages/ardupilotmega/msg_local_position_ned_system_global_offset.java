// MESSAGE LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//m.time_boot_ms = payload.getint();
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
	//m.roll = payload.getfloat();
	//m.pitch = payload.getfloat();
	//m.yaw = payload.getfloat();
    
    }

    public msg_local_position_ned_system_global_offset(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET");
	}
}

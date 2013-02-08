// MESSAGE LOCAL_POSITION_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
	//m.yaw = payload.getfloat();
	//m.coordinate_frame = payload.getbyte();
    
    }
}

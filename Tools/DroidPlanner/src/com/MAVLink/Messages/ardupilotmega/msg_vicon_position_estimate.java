// MESSAGE VICON_POSITION_ESTIMATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* 
*/
public class msg_vicon_position_estimate extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE = 104;
	public static final int MAVLINK_MSG_LENGTH = 32;

 	/**
	*Timestamp (microseconds, synced to UNIX time or since system boot)
	*/
	public long usec; 
 	/**
	*Global X position
	*/
	public float x; 
 	/**
	*Global Y position
	*/
	public float y; 
 	/**
	*Global Z position
	*/
	public float z; 
 	/**
	*Roll angle in rad
	*/
	public float roll; 
 	/**
	*Pitch angle in rad
	*/
	public float pitch; 
 	/**
	*Yaw angle in rad
	*/
	public float yaw; 

/**
 * Decode a vicon_position_estimate message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.usec = payload.getlong();
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
	//m.roll = payload.getfloat();
	//m.pitch = payload.getfloat();
	//m.yaw = payload.getfloat();
    
    }

    public msg_vicon_position_estimate(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "VICON_POSITION_ESTIMATE");
	}
}

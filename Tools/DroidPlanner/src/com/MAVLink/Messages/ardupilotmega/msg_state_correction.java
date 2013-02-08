// MESSAGE STATE_CORRECTION PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Corrects the systems state by adding an error correction term to the position and velocity, and by rotating the attitude by a correction angle.
*/
public class msg_state_correction extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_STATE_CORRECTION = 64;
	public static final int MAVLINK_MSG_LENGTH = 36;

 	/**
	*x position error
	*/
	public float xErr; 
 	/**
	*y position error
	*/
	public float yErr; 
 	/**
	*z position error
	*/
	public float zErr; 
 	/**
	*roll error (radians)
	*/
	public float rollErr; 
 	/**
	*pitch error (radians)
	*/
	public float pitchErr; 
 	/**
	*yaw error (radians)
	*/
	public float yawErr; 
 	/**
	*x velocity
	*/
	public float vxErr; 
 	/**
	*y velocity
	*/
	public float vyErr; 
 	/**
	*z velocity
	*/
	public float vzErr; 

/**
 * Decode a state_correction message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.xErr = payload.getfloat();
	//m.yErr = payload.getfloat();
	//m.zErr = payload.getfloat();
	//m.rollErr = payload.getfloat();
	//m.pitchErr = payload.getfloat();
	//m.yawErr = payload.getfloat();
	//m.vxErr = payload.getfloat();
	//m.vyErr = payload.getfloat();
	//m.vzErr = payload.getfloat();
    
    }

    public msg_state_correction(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "STATE_CORRECTION");
	}
}

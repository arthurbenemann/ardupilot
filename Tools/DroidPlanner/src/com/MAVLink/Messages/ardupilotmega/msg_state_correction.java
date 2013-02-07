// MESSAGE STATE_CORRECTION PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_state_correction m = new msg_state_correction();
	//m.xErr = _get_xErr(msg);
	//m.yErr = _get_yErr(msg);
	//m.zErr = _get_zErr(msg);
	//m.rollErr = _get_rollErr(msg);
	//m.pitchErr = _get_pitchErr(msg);
	//m.yawErr = _get_yawErr(msg);
	//m.vxErr = _get_vxErr(msg);
	//m.vyErr = _get_vyErr(msg);
	//m.vzErr = _get_vzErr(msg);
    return m;	

    }
}

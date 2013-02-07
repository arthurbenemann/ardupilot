// MESSAGE AHRS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Status of DCM attitude estimator
*/
public class msg_ahrs extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_AHRS = 163;
	public static final int MAVLINK_MSG_LENGTH = 28;

 	/**
	*X gyro drift estimate rad/s
	*/
	public float omegaIx; 
 	/**
	*Y gyro drift estimate rad/s
	*/
	public float omegaIy; 
 	/**
	*Z gyro drift estimate rad/s
	*/
	public float omegaIz; 
 	/**
	*average accel_weight
	*/
	public float accel_weight; 
 	/**
	*average renormalisation value
	*/
	public float renorm_val; 
 	/**
	*average error_roll_pitch value
	*/
	public float error_rp; 
 	/**
	*average error_yaw value
	*/
	public float error_yaw; 

/**
 * Decode a ahrs message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_ahrs m = new msg_ahrs();
	//m.omegaIx = _get_omegaIx(msg);
	//m.omegaIy = _get_omegaIy(msg);
	//m.omegaIz = _get_omegaIz(msg);
	//m.accel_weight = _get_accel_weight(msg);
	//m.renorm_val = _get_renorm_val(msg);
	//m.error_rp = _get_error_rp(msg);
	//m.error_yaw = _get_error_yaw(msg);
    return m;	

    }
}

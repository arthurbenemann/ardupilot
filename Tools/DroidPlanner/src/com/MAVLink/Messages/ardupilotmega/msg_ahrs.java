// MESSAGE AHRS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//m.omegaIx = payload.getfloat();
	//m.omegaIy = payload.getfloat();
	//m.omegaIz = payload.getfloat();
	//m.accel_weight = payload.getfloat();
	//m.renorm_val = payload.getfloat();
	//m.error_rp = payload.getfloat();
	//m.error_yaw = payload.getfloat();
    
    }

    public msg_ahrs(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "AHRS");
	}
}

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
        payload.resetIndex();
	    xErr = payload.getFloat();
	    yErr = payload.getFloat();
	    zErr = payload.getFloat();
	    rollErr = payload.getFloat();
	    pitchErr = payload.getFloat();
	    yawErr = payload.getFloat();
	    vxErr = payload.getFloat();
	    vyErr = payload.getFloat();
	    vzErr = payload.getFloat();    
    }

    public msg_state_correction(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_STATE_CORRECTION;
        unpack(payload);
        Log.d("MAVLink", "STATE_CORRECTION");
        //Log.d("MAVLINK_MSG_ID_STATE_CORRECTION", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_STATE_CORRECTION -"+" xErr:"+xErr+" yErr:"+yErr+" zErr:"+zErr+" rollErr:"+rollErr+" pitchErr:"+pitchErr+" yawErr:"+yawErr+" vxErr:"+vxErr+" vyErr:"+vyErr+" vzErr:"+vzErr+"";
    }
}

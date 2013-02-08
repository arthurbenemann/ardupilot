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
	    usec = payload.getLong();
	    x = payload.getFloat();
	    y = payload.getFloat();
	    z = payload.getFloat();
	    roll = payload.getFloat();
	    pitch = payload.getFloat();
	    yaw = payload.getFloat();    
    }

    public msg_vicon_position_estimate(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE;
        unpack(payload);
        Log.d("MAVLink", "VICON_POSITION_ESTIMATE");
    }
}

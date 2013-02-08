// MESSAGE DEBUG_VECT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* 
*/
public class msg_debug_vect extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DEBUG_VECT = 250;
	public static final int MAVLINK_MSG_LENGTH = 30;

 	/**
	*Timestamp
	*/
	public long time_usec; 
 	/**
	*x
	*/
	public float x; 
 	/**
	*y
	*/
	public float y; 
 	/**
	*z
	*/
	public float z; 
 	/**
	*Name
	*/
	public byte name[] = new byte[10]; 

/**
 * Decode a debug_vect message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.time_usec = payload.getlong();
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
	// = payload.getbyte();
    
    }

    public msg_debug_vect(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "DEBUG_VECT");
	}
}

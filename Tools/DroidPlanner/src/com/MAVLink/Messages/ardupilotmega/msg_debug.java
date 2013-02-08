// MESSAGE DEBUG PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Send a debug value. The index is used to discriminate between values. These values show up in the plot of QGroundControl as DEBUG N.
*/
public class msg_debug extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DEBUG = 254;
	public static final int MAVLINK_MSG_LENGTH = 9;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*DEBUG value
	*/
	public float value; 
 	/**
	*index of debug variable
	*/
	public byte ind; 

/**
 * Decode a debug message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    time_boot_ms = payload.getInt();
	    value = payload.getFloat();
	    ind = payload.getByte();    
    }

    public msg_debug(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_DEBUG;
        unpack(payload);
        Log.d("MAVLink", "DEBUG");
    }
}

// MESSAGE MEMINFO PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* state of APM memory
*/
public class msg_meminfo extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MEMINFO = 152;
	public static final int MAVLINK_MSG_LENGTH = 4;

 	/**
	*heap top
	*/
	public short brkval; 
 	/**
	*free memory
	*/
	public short freemem; 

/**
 * Decode a meminfo message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    brkval = payload.getShort();
	    freemem = payload.getShort();    
    }

    public msg_meminfo(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MEMINFO;
        unpack(payload);
        Log.d("MAVLink", "MEMINFO");
        //Log.d("MAVLINK_MSG_ID_MEMINFO", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_MEMINFO -"+" brkval:"+brkval+" freemem:"+freemem+"";
    }
}

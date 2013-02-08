// MESSAGE FENCE_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Status of geo-fencing. Sent in extended
	    status stream when fencing enabled
*/
public class msg_fence_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_FENCE_STATUS = 162;
	public static final int MAVLINK_MSG_LENGTH = 8;

 	/**
	*time of last breach in milliseconds since boot
	*/
	public int breach_time; 
 	/**
	*number of fence breaches
	*/
	public short breach_count; 
 	/**
	*0 if currently inside fence, 1 if outside
	*/
	public byte breach_status; 
 	/**
	*last breach type (see FENCE_BREACH_* enum)
	*/
	public byte breach_type; 

/**
 * Decode a fence_status message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.breach_time = payload.getint();
	//m.breach_count = payload.getshort();
	//m.breach_status = payload.getbyte();
	//m.breach_type = payload.getbyte();
    
    }
}

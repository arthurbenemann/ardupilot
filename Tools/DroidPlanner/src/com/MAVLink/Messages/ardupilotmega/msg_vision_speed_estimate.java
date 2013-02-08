// MESSAGE VISION_SPEED_ESTIMATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* 
*/
public class msg_vision_speed_estimate extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE = 103;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Timestamp (microseconds, synced to UNIX time or since system boot)
	*/
	public long usec; 
 	/**
	*Global X speed
	*/
	public float x; 
 	/**
	*Global Y speed
	*/
	public float y; 
 	/**
	*Global Z speed
	*/
	public float z; 

/**
 * Decode a vision_speed_estimate message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.usec = payload.getlong();
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
    
    }
}

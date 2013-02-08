// MESSAGE WIND PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Wind estimation
*/
public class msg_wind extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_WIND = 168;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*wind direction that wind is coming from (degrees)
	*/
	public float direction; 
 	/**
	*wind speed in ground plane (m/s)
	*/
	public float speed; 
 	/**
	*vertical wind speed (m/s)
	*/
	public float speed_z; 

/**
 * Decode a wind message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.direction = payload.getfloat();
	//m.speed = payload.getfloat();
	//m.speed_z = payload.getfloat();
    
    }
}

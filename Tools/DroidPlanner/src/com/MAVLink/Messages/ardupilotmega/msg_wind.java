// MESSAGE WIND PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_wind m = new msg_wind();
	//m.direction = _get_direction(msg);
	//m.speed = _get_speed(msg);
	//m.speed_z = _get_speed_z(msg);
    return m;	

    }
}

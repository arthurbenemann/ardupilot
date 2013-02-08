// MESSAGE SIMSTATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Status of simulation environment, if used
*/
public class msg_simstate extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SIMSTATE = 164;
	public static final int MAVLINK_MSG_LENGTH = 44;

 	/**
	*Roll angle (rad)
	*/
	public float roll; 
 	/**
	*Pitch angle (rad)
	*/
	public float pitch; 
 	/**
	*Yaw angle (rad)
	*/
	public float yaw; 
 	/**
	*X acceleration m/s/s
	*/
	public float xacc; 
 	/**
	*Y acceleration m/s/s
	*/
	public float yacc; 
 	/**
	*Z acceleration m/s/s
	*/
	public float zacc; 
 	/**
	*Angular speed around X axis rad/s
	*/
	public float xgyro; 
 	/**
	*Angular speed around Y axis rad/s
	*/
	public float ygyro; 
 	/**
	*Angular speed around Z axis rad/s
	*/
	public float zgyro; 
 	/**
	*Latitude in degrees
	*/
	public float lat; 
 	/**
	*Longitude in degrees
	*/
	public float lng; 

/**
 * Decode a simstate message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.roll = payload.getfloat();
	//m.pitch = payload.getfloat();
	//m.yaw = payload.getfloat();
	//m.xacc = payload.getfloat();
	//m.yacc = payload.getfloat();
	//m.zacc = payload.getfloat();
	//m.xgyro = payload.getfloat();
	//m.ygyro = payload.getfloat();
	//m.zgyro = payload.getfloat();
	//m.lat = payload.getfloat();
	//m.lng = payload.getfloat();
    
    }
}

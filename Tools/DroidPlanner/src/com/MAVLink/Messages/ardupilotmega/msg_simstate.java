// MESSAGE SIMSTATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_simstate m = new msg_simstate();
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
	//m.xacc = _get_xacc(msg);
	//m.yacc = _get_yacc(msg);
	//m.zacc = _get_zacc(msg);
	//m.xgyro = _get_xgyro(msg);
	//m.ygyro = _get_ygyro(msg);
	//m.zgyro = _get_zgyro(msg);
	//m.lat = _get_lat(msg);
	//m.lng = _get_lng(msg);
    return m;	

    }
}

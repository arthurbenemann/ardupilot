// MESSAGE NAV_CONTROLLER_OUTPUT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Outputs of the APM navigation controller. The primary use of this message is to check the response and signs of the controller before actual flight and to assist with tuning controller parameters.
*/
public class msg_nav_controller_output extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT = 62;
	public static final int MAVLINK_MSG_LENGTH = 26;

 	/**
	*Current desired roll in degrees
	*/
	public float nav_roll; 
 	/**
	*Current desired pitch in degrees
	*/
	public float nav_pitch; 
 	/**
	*Current altitude error in meters
	*/
	public float alt_error; 
 	/**
	*Current airspeed error in meters/second
	*/
	public float aspd_error; 
 	/**
	*Current crosstrack error on x-y plane in meters
	*/
	public float xtrack_error; 
 	/**
	*Current desired heading in degrees
	*/
	public short nav_bearing; 
 	/**
	*Bearing to current MISSION/target in degrees
	*/
	public short target_bearing; 
 	/**
	*Distance to active MISSION in meters
	*/
	public short wp_dist; 

/**
 * Decode a nav_controller_output message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_nav_controller_output m = new msg_nav_controller_output();
	//m.nav_roll = _get_nav_roll(msg);
	//m.nav_pitch = _get_nav_pitch(msg);
	//m.alt_error = _get_alt_error(msg);
	//m.aspd_error = _get_aspd_error(msg);
	//m.xtrack_error = _get_xtrack_error(msg);
	//m.nav_bearing = _get_nav_bearing(msg);
	//m.target_bearing = _get_target_bearing(msg);
	//m.wp_dist = _get_wp_dist(msg);
    return m;	

    }
}

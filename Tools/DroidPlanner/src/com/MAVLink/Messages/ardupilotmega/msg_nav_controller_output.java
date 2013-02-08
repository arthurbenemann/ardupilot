// MESSAGE NAV_CONTROLLER_OUTPUT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//m.nav_roll = payload.getfloat();
	//m.nav_pitch = payload.getfloat();
	//m.alt_error = payload.getfloat();
	//m.aspd_error = payload.getfloat();
	//m.xtrack_error = payload.getfloat();
	//m.nav_bearing = payload.getshort();
	//m.target_bearing = payload.getshort();
	//m.wp_dist = payload.getshort();
    
    }

    public msg_nav_controller_output(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "NAV_CONTROLLER_OUTPUT");
	}
}

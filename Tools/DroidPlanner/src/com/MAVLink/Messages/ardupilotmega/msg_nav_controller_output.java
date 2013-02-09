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
        payload.resetIndex();
	    nav_roll = payload.getFloat();
	    nav_pitch = payload.getFloat();
	    alt_error = payload.getFloat();
	    aspd_error = payload.getFloat();
	    xtrack_error = payload.getFloat();
	    nav_bearing = payload.getShort();
	    target_bearing = payload.getShort();
	    wp_dist = payload.getShort();    
    }

    public msg_nav_controller_output(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT;
        unpack(payload);
        Log.d("MAVLink", "NAV_CONTROLLER_OUTPUT");
        //Log.d("MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT -"+" nav_roll:"+nav_roll+" nav_pitch:"+nav_pitch+" alt_error:"+alt_error+" aspd_error:"+aspd_error+" xtrack_error:"+xtrack_error+" nav_bearing:"+nav_bearing+" target_bearing:"+target_bearing+" wp_dist:"+wp_dist+"";
    }
}

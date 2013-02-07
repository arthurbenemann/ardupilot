// MESSAGE VFR_HUD PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Metrics typically displayed on a HUD for fixed wing aircraft
*/
public class msg_vfr_hud extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_VFR_HUD = 74;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Current airspeed in m/s
	*/
	public float airspeed; 
 	/**
	*Current ground speed in m/s
	*/
	public float groundspeed; 
 	/**
	*Current altitude (MSL), in meters
	*/
	public float alt; 
 	/**
	*Current climb rate in meters/second
	*/
	public float climb; 
 	/**
	*Current heading in degrees, in compass units (0..360, 0=north)
	*/
	public short heading; 
 	/**
	*Current throttle setting in integer percent, 0 to 100
	*/
	public short throttle; 

/**
 * Decode a vfr_hud message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_vfr_hud m = new msg_vfr_hud();
	//m.airspeed = _get_airspeed(msg);
	//m.groundspeed = _get_groundspeed(msg);
	//m.alt = _get_alt(msg);
	//m.climb = _get_climb(msg);
	//m.heading = _get_heading(msg);
	//m.throttle = _get_throttle(msg);
    return m;	

    }
}

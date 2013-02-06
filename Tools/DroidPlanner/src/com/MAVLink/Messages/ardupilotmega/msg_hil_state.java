// MESSAGE HIL_STATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Sent from simulation to autopilot. This packet is useful for high throughput applications such as hardware in the loop simulations.
*/
public class msg_hil_state extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HIL_STATE = 90;
	public static final int MAVLINK_MSG_LENGTH = 56;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
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
	*Roll angular speed (rad/s)
	*/
	public float rollspeed; 
 	/**
	*Pitch angular speed (rad/s)
	*/
	public float pitchspeed; 
 	/**
	*Yaw angular speed (rad/s)
	*/
	public float yawspeed; 
 	/**
	*Latitude, expressed as * 1E7
	*/
	public int lat; 
 	/**
	*Longitude, expressed as * 1E7
	*/
	public int lon; 
 	/**
	*Altitude in meters, expressed as * 1000 (millimeters)
	*/
	public int alt; 
 	/**
	*Ground X Speed (Latitude), expressed as m/s * 100
	*/
	public short vx; 
 	/**
	*Ground Y Speed (Longitude), expressed as m/s * 100
	*/
	public short vy; 
 	/**
	*Ground Z Speed (Altitude), expressed as m/s * 100
	*/
	public short vz; 
 	/**
	*X acceleration (mg)
	*/
	public short xacc; 
 	/**
	*Y acceleration (mg)
	*/
	public short yacc; 
 	/**
	*Z acceleration (mg)
	*/
	public short zacc; 


/**
 * Decode a hil_state message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_hil_state m = new msg_hil_state();
	//m.time_usec = _get_time_usec(msg);
	//m.roll = _get_roll(msg);
	//m.pitch = _get_pitch(msg);
	//m.yaw = _get_yaw(msg);
	//m.rollspeed = _get_rollspeed(msg);
	//m.pitchspeed = _get_pitchspeed(msg);
	//m.yawspeed = _get_yawspeed(msg);
	//m.lat = _get_lat(msg);
	//m.lon = _get_lon(msg);
	//m.alt = _get_alt(msg);
	//m.vx = _get_vx(msg);
	//m.vy = _get_vy(msg);
	//m.vz = _get_vz(msg);
	//m.xacc = _get_xacc(msg);
	//m.yacc = _get_yacc(msg);
	//m.zacc = _get_zacc(msg);
    return m;	

    }
}

// MESSAGE HIL_CONTROLS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Sent from autopilot to simulation. Hardware in the loop control outputs
*/
public class msg_hil_controls extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HIL_CONTROLS = 91;
	public static final int MAVLINK_MSG_LENGTH = 42;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*Control output -1 .. 1
	*/
	public float roll_ailerons; 
 	/**
	*Control output -1 .. 1
	*/
	public float pitch_elevator; 
 	/**
	*Control output -1 .. 1
	*/
	public float yaw_rudder; 
 	/**
	*Throttle 0 .. 1
	*/
	public float throttle; 
 	/**
	*Aux 1, -1 .. 1
	*/
	public float aux1; 
 	/**
	*Aux 2, -1 .. 1
	*/
	public float aux2; 
 	/**
	*Aux 3, -1 .. 1
	*/
	public float aux3; 
 	/**
	*Aux 4, -1 .. 1
	*/
	public float aux4; 
 	/**
	*System mode (MAV_MODE)
	*/
	public byte mode; 
 	/**
	*Navigation mode (MAV_NAV_MODE)
	*/
	public byte nav_mode; 


/**
 * Decode a hil_controls message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_hil_controls m = new msg_hil_controls();
	//m.time_usec = _get_time_usec(msg);
	//m.roll_ailerons = _get_roll_ailerons(msg);
	//m.pitch_elevator = _get_pitch_elevator(msg);
	//m.yaw_rudder = _get_yaw_rudder(msg);
	//m.throttle = _get_throttle(msg);
	//m.aux1 = _get_aux1(msg);
	//m.aux2 = _get_aux2(msg);
	//m.aux3 = _get_aux3(msg);
	//m.aux4 = _get_aux4(msg);
	//m.mode = _get_mode(msg);
	//m.nav_mode = _get_nav_mode(msg);
    return m;	

    }
}

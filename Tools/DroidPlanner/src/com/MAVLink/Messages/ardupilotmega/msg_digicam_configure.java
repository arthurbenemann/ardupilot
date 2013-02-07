// MESSAGE DIGICAM_CONFIGURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Configure on-board Camera Control System.
*/
public class msg_digicam_configure extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DIGICAM_CONFIGURE = 154;
	public static final int MAVLINK_MSG_LENGTH = 15;

 	/**
	*Correspondent value to given extra_param
	*/
	public float extra_value; 
 	/**
	*Divisor number //e.g. 1000 means 1/1000 (0 means ignore)
	*/
	public short shutter_speed; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore)
	*/
	public byte mode; 
 	/**
	*F stop number x 10 //e.g. 28 means 2.8 (0 means ignore)
	*/
	public byte aperture; 
 	/**
	*ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore)
	*/
	public byte iso; 
 	/**
	*Exposure type enumeration from 1 to N (0 means ignore)
	*/
	public byte exposure_type; 
 	/**
	*Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed or pooled just once
	*/
	public byte command_id; 
 	/**
	*Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off)
	*/
	public byte engine_cut_off; 
 	/**
	*Extra parameters enumeration (0 means ignore)
	*/
	public byte extra_param; 

/**
 * Decode a digicam_configure message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_digicam_configure m = new msg_digicam_configure();
	//m.extra_value = _get_extra_value(msg);
	//m.shutter_speed = _get_shutter_speed(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.mode = _get_mode(msg);
	//m.aperture = _get_aperture(msg);
	//m.iso = _get_iso(msg);
	//m.exposure_type = _get_exposure_type(msg);
	//m.command_id = _get_command_id(msg);
	//m.engine_cut_off = _get_engine_cut_off(msg);
	//m.extra_param = _get_extra_param(msg);
    return m;	

    }
}

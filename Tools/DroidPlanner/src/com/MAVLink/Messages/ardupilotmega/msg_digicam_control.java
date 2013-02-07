// MESSAGE DIGICAM_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Control on-board Camera Control System to take shots.
*/
public class msg_digicam_control extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DIGICAM_CONTROL = 155;
	public static final int MAVLINK_MSG_LENGTH = 13;

 	/**
	*Correspondent value to given extra_param
	*/
	public float extra_value; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*0: stop, 1: start or keep it up //Session control e.g. show/hide lens
	*/
	public byte session; 
 	/**
	*1 to N //Zoom's absolute position (0 means ignore)
	*/
	public byte zoom_pos; 
 	/**
	*-100 to 100 //Zooming step value to offset zoom from the current position
	*/
	public byte zoom_step; 
 	/**
	*0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus
	*/
	public byte focus_lock; 
 	/**
	*0: ignore, 1: shot or start filming
	*/
	public byte shot; 
 	/**
	*Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed or pooled just once
	*/
	public byte command_id; 
 	/**
	*Extra parameters enumeration (0 means ignore)
	*/
	public byte extra_param; 

/**
 * Decode a digicam_control message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_digicam_control m = new msg_digicam_control();
	//m.extra_value = _get_extra_value(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.session = _get_session(msg);
	//m.zoom_pos = _get_zoom_pos(msg);
	//m.zoom_step = _get_zoom_step(msg);
	//m.focus_lock = _get_focus_lock(msg);
	//m.shot = _get_shot(msg);
	//m.command_id = _get_command_id(msg);
	//m.extra_param = _get_extra_param(msg);
    return m;	

    }
}

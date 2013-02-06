// MESSAGE LIMITS_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Status of AP_Limits. Sent in extended
	    status stream when AP_Limits is enabled
*/
public class msg_limits_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_LIMITS_STATUS = 167;
	public static final int MAVLINK_MSG_LENGTH = 22;

 	/**
	*time of last breach in milliseconds since boot
	*/
	public int last_trigger; 
 	/**
	*time of last recovery action in milliseconds since boot
	*/
	public int last_action; 
 	/**
	*time of last successful recovery in milliseconds since boot
	*/
	public int last_recovery; 
 	/**
	*time of last all-clear in milliseconds since boot
	*/
	public int last_clear; 
 	/**
	*number of fence breaches
	*/
	public short breach_count; 
 	/**
	*state of AP_Limits, (see enum LimitState, LIMITS_STATE)
	*/
	public byte limits_state; 
 	/**
	*AP_Limit_Module bitfield of enabled modules, (see enum moduleid or LIMIT_MODULE)
	*/
	public byte mods_enabled; 
 	/**
	*AP_Limit_Module bitfield of required modules, (see enum moduleid or LIMIT_MODULE)
	*/
	public byte mods_required; 
 	/**
	*AP_Limit_Module bitfield of triggered modules, (see enum moduleid or LIMIT_MODULE)
	*/
	public byte mods_triggered; 


/**
 * Decode a limits_status message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_limits_status m = new msg_limits_status();
	//m.last_trigger = _get_last_trigger(msg);
	//m.last_action = _get_last_action(msg);
	//m.last_recovery = _get_last_recovery(msg);
	//m.last_clear = _get_last_clear(msg);
	//m.breach_count = _get_breach_count(msg);
	//m.limits_state = _get_limits_state(msg);
	//m.mods_enabled = _get_mods_enabled(msg);
	//m.mods_required = _get_mods_required(msg);
	//m.mods_triggered = _get_mods_triggered(msg);
    return m;	

    }
}

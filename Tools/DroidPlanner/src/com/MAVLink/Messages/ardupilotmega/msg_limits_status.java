// MESSAGE LIMITS_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.last_trigger = payload.getint();
	//m.last_action = payload.getint();
	//m.last_recovery = payload.getint();
	//m.last_clear = payload.getint();
	//m.breach_count = payload.getshort();
	//m.limits_state = payload.getbyte();
	//m.mods_enabled = payload.getbyte();
	//m.mods_required = payload.getbyte();
	//m.mods_triggered = payload.getbyte();
    
    }
}

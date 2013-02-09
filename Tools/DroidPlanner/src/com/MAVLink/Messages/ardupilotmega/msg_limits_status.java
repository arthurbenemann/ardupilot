// MESSAGE LIMITS_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    last_trigger = payload.getInt();
	    last_action = payload.getInt();
	    last_recovery = payload.getInt();
	    last_clear = payload.getInt();
	    breach_count = payload.getShort();
	    limits_state = payload.getByte();
	    mods_enabled = payload.getByte();
	    mods_required = payload.getByte();
	    mods_triggered = payload.getByte();    
    }

    public msg_limits_status(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_LIMITS_STATUS;
        unpack(payload);
        Log.d("MAVLink", "LIMITS_STATUS");
        //Log.d("MAVLINK_MSG_ID_LIMITS_STATUS", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_LIMITS_STATUS -"+" last_trigger:"+last_trigger+" last_action:"+last_action+" last_recovery:"+last_recovery+" last_clear:"+last_clear+" breach_count:"+breach_count+" limits_state:"+limits_state+" mods_enabled:"+mods_enabled+" mods_required:"+mods_required+" mods_triggered:"+mods_triggered+"";
    }
}

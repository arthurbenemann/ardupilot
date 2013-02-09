// MESSAGE MOUNT_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Message to control a camera mount, directional antenna, etc.
*/
public class msg_mount_control extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MOUNT_CONTROL = 157;
	public static final int MAVLINK_MSG_LENGTH = 15;

 	/**
	*pitch(deg*100) or lat, depending on mount mode
	*/
	public int input_a; 
 	/**
	*roll(deg*100) or lon depending on mount mode
	*/
	public int input_b; 
 	/**
	*yaw(deg*100) or alt (in cm) depending on mount mode
	*/
	public int input_c; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING)
	*/
	public byte save_position; 

/**
 * Decode a mount_control message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    input_a = payload.getInt();
	    input_b = payload.getInt();
	    input_c = payload.getInt();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    save_position = payload.getByte();    
    }

    public msg_mount_control(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MOUNT_CONTROL;
        unpack(payload);
        Log.d("MAVLink", "MOUNT_CONTROL");
        //Log.d("MAVLINK_MSG_ID_MOUNT_CONTROL", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_MOUNT_CONTROL -"+" input_a:"+input_a+" input_b:"+input_b+" input_c:"+input_c+" target_system:"+target_system+" target_component:"+target_component+" save_position:"+save_position+"";
    }
}

// MESSAGE SET_MODE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is by definition for the overall aircraft, not only for one component.
*/
public class msg_set_mode extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_MODE = 11;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*The new autopilot-specific mode. This field can be ignored by an autopilot.
	*/
	public int custom_mode; 
 	/**
	*The system setting the mode
	*/
	public byte target_system; 
 	/**
	*The new base mode
	*/
	public byte base_mode; 

/**
 * Decode a set_mode message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//custom_mode = payload.getInt();
	//target_system = payload.getByte();
	//base_mode = payload.getByte();
    
    }

    public msg_set_mode(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_SET_MODE;
    unpack(payload);
    Log.d("MAVLink", "SET_MODE");
    }
}

// MESSAGE DIGICAM_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//extra_value = payload.getFloat();
	//target_system = payload.getByte();
	//target_component = payload.getByte();
	//session = payload.getByte();
	//zoom_pos = payload.getByte();
	//zoom_step = payload.getByte();
	//focus_lock = payload.getByte();
	//shot = payload.getByte();
	//command_id = payload.getByte();
	//extra_param = payload.getByte();
    
    }

    public msg_digicam_control(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_DIGICAM_CONTROL;
    unpack(payload);
    Log.d("MAVLink", "DIGICAM_CONTROL");
    }
}

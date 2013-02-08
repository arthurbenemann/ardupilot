// MESSAGE MOUNT_CONFIGURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Message to configure a camera mount, directional antenna, etc.
*/
public class msg_mount_configure extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MOUNT_CONFIGURE = 156;
	public static final int MAVLINK_MSG_LENGTH = 6;

 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*mount operating mode (see MAV_MOUNT_MODE enum)
	*/
	public byte mount_mode; 
 	/**
	*(1 = yes, 0 = no)
	*/
	public byte stab_roll; 
 	/**
	*(1 = yes, 0 = no)
	*/
	public byte stab_pitch; 
 	/**
	*(1 = yes, 0 = no)
	*/
	public byte stab_yaw; 

/**
 * Decode a mount_configure message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    mount_mode = payload.getByte();
	    stab_roll = payload.getByte();
	    stab_pitch = payload.getByte();
	    stab_yaw = payload.getByte();    
    }

    public msg_mount_configure(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MOUNT_CONFIGURE;
        unpack(payload);
        Log.d("MAVLink", "MOUNT_CONFIGURE");
    }
}

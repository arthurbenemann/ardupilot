// MESSAGE MOUNT_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Message with some status from APM to GCS about camera or antenna mount
*/
public class msg_mount_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MOUNT_STATUS = 158;
	public static final int MAVLINK_MSG_LENGTH = 14;

 	/**
	*pitch(deg*100) or lat, depending on mount mode
	*/
	public int pointing_a; 
 	/**
	*roll(deg*100) or lon depending on mount mode
	*/
	public int pointing_b; 
 	/**
	*yaw(deg*100) or alt (in cm) depending on mount mode
	*/
	public int pointing_c; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a mount_status message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    pointing_a = payload.getInt();
	    pointing_b = payload.getInt();
	    pointing_c = payload.getInt();
	    target_system = payload.getByte();
	    target_component = payload.getByte();    
    }

    public msg_mount_status(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MOUNT_STATUS;
        unpack(payload);
        Log.d("MAVLink", "MOUNT_STATUS");
    }
}

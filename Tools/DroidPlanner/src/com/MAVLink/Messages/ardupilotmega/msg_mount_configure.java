// MESSAGE MOUNT_CONFIGURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
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
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_MOUNT_CONFIGURE;
		packet.len = MAVLINK_MSG_LENGTH;
		packet.payload.putByte(target_system);
		packet.payload.putByte(target_component);
		packet.payload.putByte(mount_mode);
		packet.payload.putByte(stab_roll);
		packet.payload.putByte(stab_pitch);
		packet.payload.putByte(stab_yaw);
		return packet;		
	}

    /**
     * Decode a mount_configure message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    mount_mode = payload.getByte();
	    stab_roll = payload.getByte();
	    stab_pitch = payload.getByte();
	    stab_yaw = payload.getByte();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_mount_configure(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MOUNT_CONFIGURE;
        unpack(payload);
        Log.d("MAVLink", "MOUNT_CONFIGURE");
        //Log.d("MAVLINK_MSG_ID_MOUNT_CONFIGURE", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_MOUNT_CONFIGURE -"+" target_system:"+target_system+" target_component:"+target_component+" mount_mode:"+mount_mode+" stab_roll:"+stab_roll+" stab_pitch:"+stab_pitch+" stab_yaw:"+stab_yaw+"";
    }
}

// MESSAGE PARAM_SET PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. IMPORTANT: The receiving component should acknowledge the new parameter value by sending a param_value message to all communication partners. This will also ensure that multiple GCS all have an up-to-date list of all parameters. If the sending GCS did not receive a PARAM_VALUE message within its timeout time, it should re-send the PARAM_SET message.
*/
public class msg_param_set extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PARAM_SET = 23;
	public static final int MAVLINK_MSG_LENGTH = 23;

 	/**
	*Onboard parameter value
	*/
	public float param_value; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string
	*/
	public byte param_id[] = new byte[16]; 
 	/**
	*Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types.
	*/
	public byte param_type; 

/**
 * Decode a param_set message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    param_value = payload.getFloat();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	     for (int i = 0; i < param_id.length; i++) {
			param_id[i] = payload.getByte();
		}
	    param_type = payload.getByte();    
    }

    public msg_param_set(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_PARAM_SET;
        unpack(payload);
        Log.d("MAVLink", "PARAM_SET");
    }
}

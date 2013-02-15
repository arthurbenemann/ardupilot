// MESSAGE PARAM_SET PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. IMPORTANT: The receiving component should acknowledge the new parameter value by sending a param_value message to all communication partners. This will also ensure that multiple GCS all have an up-to-date list of all parameters. If the sending GCS did not receive a PARAM_VALUE message within its timeout time, it should re-send the PARAM_SET message.
*/
public class msg_param_set extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PARAM_SET = 23;
	public static final int MAVLINK_MSG_LENGTH = 23;
	private static final long serialVersionUID = MAVLINK_MSG_ID_PARAM_SET;
	

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
	public char param_id[] = new char[16]; 
 	/**
	*Onboard parameter type: see the MAV_PARAM_TYPE enum for supported data types.
	*/
	public byte param_type; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_PARAM_SET;
		packet.payload.putFloat(param_value);
		packet.payload.putByte(target_system);
		packet.payload.putByte(target_component);
		 for (int i = 0; i < param_id.length; i++) {
                        packet.payload.putChar(param_id[i]);
            }
		packet.payload.putByte(param_type);
		return packet;		
	}

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
			param_id[i] = payload.getChar();
		}
	    param_type = payload.getByte();    
    }

     /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_param_set(){
    	msgid = MAVLINK_MSG_ID_PARAM_SET;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_param_set(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_PARAM_SET;
        unpack(payload);
        Log.d("MAVLink", "PARAM_SET");
        //Log.d("MAVLINK_MSG_ID_PARAM_SET", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_PARAM_SET -"+" param_value:"+param_value+" target_system:"+target_system+" target_component:"+target_component+" param_id:"+param_id+" param_type:"+param_type+"";
    }
}

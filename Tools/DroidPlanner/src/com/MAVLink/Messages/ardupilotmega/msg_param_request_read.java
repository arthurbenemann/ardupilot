// MESSAGE PARAM_REQUEST_READ PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Request to read the onboard parameter with the param_id string id. Onboard parameters are stored as key[const char*] -> value[float]. This allows to send a parameter to any other component (such as the GCS) without the need of previous knowledge of possible parameter names. Thus the same GCS can store different parameters for different autopilots. See also http://qgroundcontrol.org/parameter_interface for a full documentation of QGroundControl and IMU code.
*/
public class msg_param_request_read extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PARAM_REQUEST_READ = 20;
	public static final int MAVLINK_MSG_LENGTH = 20;
	private static final long serialVersionUID = MAVLINK_MSG_ID_PARAM_REQUEST_READ;
	

 	/**
	*Parameter index. Send -1 to use the param ID field as identifier (else the param id will be ignored)
	*/
	public short param_index; 
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
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_PARAM_REQUEST_READ;
		packet.payload.putShort(param_index);
		packet.payload.putByte(target_system);
		packet.payload.putByte(target_component);
		 for (int i = 0; i < param_id.length; i++) {
                        packet.payload.putChar(param_id[i]);
            }
		return packet;		
	}

    /**
     * Decode a param_request_read message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    param_index = payload.getShort();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	     for (int i = 0; i < param_id.length; i++) {
			param_id[i] = payload.getChar();
		}    
    }

     /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_param_request_read(){
    	msgid = MAVLINK_MSG_ID_PARAM_REQUEST_READ;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_param_request_read(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_PARAM_REQUEST_READ;
        unpack(payload);
        Log.d("MAVLink", "PARAM_REQUEST_READ");
        //Log.d("MAVLINK_MSG_ID_PARAM_REQUEST_READ", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_PARAM_REQUEST_READ -"+" param_index:"+param_index+" target_system:"+target_system+" target_component:"+target_component+" param_id:"+param_id+"";
    }
}

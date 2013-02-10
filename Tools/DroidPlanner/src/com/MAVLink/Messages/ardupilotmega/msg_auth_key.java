// MESSAGE AUTH_KEY PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been kept simple, so transmitting the key requires an encrypted channel for true safety.
*/
public class msg_auth_key extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_AUTH_KEY = 7;
	public static final int MAVLINK_MSG_LENGTH = 32;

 	/**
	*key
	*/
	public byte key[] = new byte[32]; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_AUTH_KEY;
		 for (int i = 0; i < key.length; i++) {
                        packet.payload.putByte(key[i]);
            }
		return packet;		
	}

    /**
     * Decode a auth_key message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	     for (int i = 0; i < key.length; i++) {
			key[i] = payload.getByte();
		}    
    }

     /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_auth_key(){
    	msgid = MAVLINK_MSG_ID_AUTH_KEY;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_auth_key(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_AUTH_KEY;
        unpack(payload);
        Log.d("MAVLink", "AUTH_KEY");
        //Log.d("MAVLINK_MSG_ID_AUTH_KEY", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_AUTH_KEY -"+" key:"+key+"";
    }
}

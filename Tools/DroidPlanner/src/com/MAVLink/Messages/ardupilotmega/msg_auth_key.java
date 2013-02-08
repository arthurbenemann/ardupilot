// MESSAGE AUTH_KEY PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
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

    public msg_auth_key(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_AUTH_KEY;
        unpack(payload);
        Log.d("MAVLink", "AUTH_KEY");
    }
}

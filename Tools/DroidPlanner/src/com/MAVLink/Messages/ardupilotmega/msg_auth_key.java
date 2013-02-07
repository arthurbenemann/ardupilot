// MESSAGE AUTH_KEY PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_auth_key m = new msg_auth_key();
	// = _get_key(msgm.key);
    return m;	

    }
}

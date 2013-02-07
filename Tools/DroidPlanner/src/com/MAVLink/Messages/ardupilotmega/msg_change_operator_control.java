// MESSAGE CHANGE_OPERATOR_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Request to control this MAV
*/
public class msg_change_operator_control extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL = 5;
	public static final int MAVLINK_MSG_LENGTH = 28;

 	/**
	*System the GCS requests control for
	*/
	public byte target_system; 
 	/**
	*0: request control of this MAV, 1: Release control of this MAV
	*/
	public byte control_request; 
 	/**
	*0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in general use the safest mode possible initially and then gradually move down the encryption level if it gets a NACK message indicating an encryption mismatch.
	*/
	public byte version; 
 	/**
	*Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-"
	*/
	public byte passkey[] = new byte[25]; 

/**
 * Decode a change_operator_control message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_change_operator_control m = new msg_change_operator_control();
	//m.target_system = _get_target_system(msg);
	//m.control_request = _get_control_request(msg);
	//m.version = _get_version(msg);
	// = _get_passkey(msgm.passkey);
    return m;	

    }
}

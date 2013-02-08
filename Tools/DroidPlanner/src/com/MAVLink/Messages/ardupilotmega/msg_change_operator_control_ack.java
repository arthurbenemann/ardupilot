// MESSAGE CHANGE_OPERATOR_CONTROL_ACK PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Accept / deny control of this MAV
*/
public class msg_change_operator_control_ack extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK = 6;
	public static final int MAVLINK_MSG_LENGTH = 3;

 	/**
	*ID of the GCS this message 
	*/
	public byte gcs_system_id; 
 	/**
	*0: request control of this MAV, 1: Release control of this MAV
	*/
	public byte control_request; 
 	/**
	*0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: Already under control
	*/
	public byte ack; 

/**
 * Decode a change_operator_control_ack message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.gcs_system_id = payload.getbyte();
	//m.control_request = payload.getbyte();
	//m.ack = payload.getbyte();
    
    }
}

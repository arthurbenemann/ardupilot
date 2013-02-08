// MESSAGE COMMAND_ACK PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Report status of a command. Includes feedback wether the command was executed.
*/
public class msg_command_ack extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_COMMAND_ACK = 77;
	public static final int MAVLINK_MSG_LENGTH = 3;

 	/**
	*Command ID, as defined by MAV_CMD enum.
	*/
	public short command; 
 	/**
	*See MAV_RESULT enum
	*/
	public byte result; 

/**
 * Decode a command_ack message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.command = payload.getshort();
	//m.result = payload.getbyte();
    
    }
}

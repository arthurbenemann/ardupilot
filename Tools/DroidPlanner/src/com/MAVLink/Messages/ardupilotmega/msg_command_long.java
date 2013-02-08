// MESSAGE COMMAND_LONG PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Send a command with up to four parameters to the MAV
*/
public class msg_command_long extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_COMMAND_LONG = 76;
	public static final int MAVLINK_MSG_LENGTH = 33;

 	/**
	*Parameter 1, as defined by MAV_CMD enum.
	*/
	public float param1; 
 	/**
	*Parameter 2, as defined by MAV_CMD enum.
	*/
	public float param2; 
 	/**
	*Parameter 3, as defined by MAV_CMD enum.
	*/
	public float param3; 
 	/**
	*Parameter 4, as defined by MAV_CMD enum.
	*/
	public float param4; 
 	/**
	*Parameter 5, as defined by MAV_CMD enum.
	*/
	public float param5; 
 	/**
	*Parameter 6, as defined by MAV_CMD enum.
	*/
	public float param6; 
 	/**
	*Parameter 7, as defined by MAV_CMD enum.
	*/
	public float param7; 
 	/**
	*Command ID, as defined by MAV_CMD enum.
	*/
	public short command; 
 	/**
	*System which should execute the command
	*/
	public byte target_system; 
 	/**
	*Component which should execute the command, 0 for all components
	*/
	public byte target_component; 
 	/**
	*0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill command)
	*/
	public byte confirmation; 

/**
 * Decode a command_long message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.param1 = payload.getfloat();
	//m.param2 = payload.getfloat();
	//m.param3 = payload.getfloat();
	//m.param4 = payload.getfloat();
	//m.param5 = payload.getfloat();
	//m.param6 = payload.getfloat();
	//m.param7 = payload.getfloat();
	//m.command = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
	//m.confirmation = payload.getbyte();
    
    }
}

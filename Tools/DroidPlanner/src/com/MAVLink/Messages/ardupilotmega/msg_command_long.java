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
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_command_long m = new msg_command_long();
	//m.param1 = _get_param1(msg);
	//m.param2 = _get_param2(msg);
	//m.param3 = _get_param3(msg);
	//m.param4 = _get_param4(msg);
	//m.param5 = _get_param5(msg);
	//m.param6 = _get_param6(msg);
	//m.param7 = _get_param7(msg);
	//m.command = _get_command(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.confirmation = _get_confirmation(msg);
    return m;	

    }
}

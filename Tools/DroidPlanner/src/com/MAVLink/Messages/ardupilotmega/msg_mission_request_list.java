// MESSAGE MISSION_REQUEST_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Request the overall list of mission items from the system/component.
*/
public class msg_mission_request_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_REQUEST_LIST = 43;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a mission_request_list message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }
}

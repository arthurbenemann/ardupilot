// MESSAGE MISSION_COUNT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* This message is emitted as response to MISSION_REQUEST_LIST by the MAV and to initiate a write transaction. The GCS can then request the individual mission item based on the knowledge of the total number of MISSIONs.
*/
public class msg_mission_count extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_COUNT = 44;
	public static final int MAVLINK_MSG_LENGTH = 4;

 	/**
	*Number of mission items in the sequence
	*/
	public short count; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a mission_count message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.count = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }
}

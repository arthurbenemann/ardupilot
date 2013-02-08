// MESSAGE SAFETY_SET_ALLOWED_AREA PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Set a safety zone (volume), which is defined by two corners of a cube. This message can be used to tell the MAV which setpoints/MISSIONs to accept and which to reject. Safety areas are often enforced by national or competition regulations.
*/
public class msg_safety_set_allowed_area extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SAFETY_SET_ALLOWED_AREA = 54;
	public static final int MAVLINK_MSG_LENGTH = 27;

 	/**
	*x position 1 / Latitude 1
	*/
	public float p1x; 
 	/**
	*y position 1 / Longitude 1
	*/
	public float p1y; 
 	/**
	*z position 1 / Altitude 1
	*/
	public float p1z; 
 	/**
	*x position 2 / Latitude 2
	*/
	public float p2x; 
 	/**
	*y position 2 / Longitude 2
	*/
	public float p2y; 
 	/**
	*z position 2 / Altitude 2
	*/
	public float p2z; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*Coordinate frame, as defined by MAV_FRAME enum in mavlink_types.h. Can be either global, GPS, right-handed with Z axis up or local, right handed, Z axis down.
	*/
	public byte frame; 

/**
 * Decode a safety_set_allowed_area message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.p1x = payload.getfloat();
	//m.p1y = payload.getfloat();
	//m.p1z = payload.getfloat();
	//m.p2x = payload.getfloat();
	//m.p2y = payload.getfloat();
	//m.p2z = payload.getfloat();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
	//m.frame = payload.getbyte();
    
    }
}

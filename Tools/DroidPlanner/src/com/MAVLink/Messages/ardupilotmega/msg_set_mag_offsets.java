// MESSAGE SET_MAG_OFFSETS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* set the magnetometer offsets
*/
public class msg_set_mag_offsets extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_MAG_OFFSETS = 151;
	public static final int MAVLINK_MSG_LENGTH = 8;

 	/**
	*magnetometer X offset
	*/
	public short mag_ofs_x; 
 	/**
	*magnetometer Y offset
	*/
	public short mag_ofs_y; 
 	/**
	*magnetometer Z offset
	*/
	public short mag_ofs_z; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a set_mag_offsets message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.mag_ofs_x = payload.getshort();
	//m.mag_ofs_y = payload.getshort();
	//m.mag_ofs_z = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }
}

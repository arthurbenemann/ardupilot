// MESSAGE SET_MAG_OFFSETS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_set_mag_offsets m = new msg_set_mag_offsets();
	//m.mag_ofs_x = _get_mag_ofs_x(msg);
	//m.mag_ofs_y = _get_mag_ofs_y(msg);
	//m.mag_ofs_z = _get_mag_ofs_z(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

// MESSAGE MEMORY_VECT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Send raw controller memory. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.
*/
public class msg_memory_vect extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MEMORY_VECT = 249;
	public static final int MAVLINK_MSG_LENGTH = 36;

 	/**
	*Starting address of the debug variables
	*/
	public short address; 
 	/**
	*Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below
	*/
	public byte ver; 
 	/**
	*Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 1Q14
	*/
	public byte type; 
 	/**
	*Memory contents at specified address
	*/
	public byte value[] = new byte[32]; 

/**
 * Decode a memory_vect message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_memory_vect m = new msg_memory_vect();
	//m.address = _get_address(msg);
	//m.ver = _get_ver(msg);
	//m.type = _get_type(msg);
	// = _get_value(msgm.value);
    return m;	

    }
}

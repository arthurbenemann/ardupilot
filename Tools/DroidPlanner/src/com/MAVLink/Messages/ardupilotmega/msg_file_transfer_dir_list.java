// MESSAGE FILE_TRANSFER_DIR_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Get directory listing
*/
public class msg_file_transfer_dir_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST = 111;
	public static final int MAVLINK_MSG_LENGTH = 249;

 	/**
	*Unique transfer ID
	*/
	public long transfer_uid; 
 	/**
	*Directory path to list
	*/
	public byte dir_path[] = new byte[240]; 
 	/**
	*RESERVED
	*/
	public byte flags; 

/**
 * Decode a file_transfer_dir_list message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_file_transfer_dir_list m = new msg_file_transfer_dir_list();
	//m.transfer_uid = _get_transfer_uid(msg);
	// = _get_dir_path(msgm.dir_path);
	//m.flags = _get_flags(msg);
    return m;	

    }
}

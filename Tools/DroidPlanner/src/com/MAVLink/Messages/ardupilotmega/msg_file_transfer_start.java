// MESSAGE FILE_TRANSFER_START PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Begin file transfer
*/
public class msg_file_transfer_start extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_FILE_TRANSFER_START = 110;
	public static final int MAVLINK_MSG_LENGTH = 254;

 	/**
	*Unique transfer ID
	*/
	public long transfer_uid; 
 	/**
	*File size in bytes
	*/
	public int file_size; 
 	/**
	*Destination path
	*/
	public byte dest_path[] = new byte[240]; 
 	/**
	*Transfer direction: 0: from requester, 1: to requester
	*/
	public byte direction; 
 	/**
	*RESERVED
	*/
	public byte flags; 

/**
 * Decode a file_transfer_start message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.transfer_uid = payload.getlong();
	//m.file_size = payload.getint();
	// = payload.getbyte();
	//m.direction = payload.getbyte();
	//m.flags = payload.getbyte();
    
    }
}

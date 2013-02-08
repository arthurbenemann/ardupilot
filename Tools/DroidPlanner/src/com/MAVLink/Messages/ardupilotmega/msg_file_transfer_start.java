// MESSAGE FILE_TRANSFER_START PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
	    transfer_uid = payload.getLong();
	    file_size = payload.getInt();
	     for (int i = 0; i < dest_path.length; i++) {
			dest_path[i] = payload.getByte();
		}
	    direction = payload.getByte();
	    flags = payload.getByte();    
    }

    public msg_file_transfer_start(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_FILE_TRANSFER_START;
        unpack(payload);
        Log.d("MAVLink", "FILE_TRANSFER_START");
    }
}

// MESSAGE FILE_TRANSFER_DIR_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
public void unpack(MAVLinkPayload payload) {
	//m.transfer_uid = payload.getlong();
	// = payload.getbyte();
	//m.flags = payload.getbyte();
    
    }

    public msg_file_transfer_dir_list(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "FILE_TRANSFER_DIR_LIST");
	}
}

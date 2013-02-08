// MESSAGE FILE_TRANSFER_RES PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* File transfer result
*/
public class msg_file_transfer_res extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_FILE_TRANSFER_RES = 112;
	public static final int MAVLINK_MSG_LENGTH = 9;

 	/**
	*Unique transfer ID
	*/
	public long transfer_uid; 
 	/**
	*0: OK, 1: not permitted, 2: bad path / file name, 3: no space left on device
	*/
	public byte result; 

/**
 * Decode a file_transfer_res message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    transfer_uid = payload.getLong();
	    result = payload.getByte();    
    }

    public msg_file_transfer_res(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_FILE_TRANSFER_RES;
        unpack(payload);
        Log.d("MAVLink", "FILE_TRANSFER_RES");
    }
}

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
	//m.transfer_uid = payload.getlong();
	//m.result = payload.getbyte();
    
    }

    public msg_file_transfer_res(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "FILE_TRANSFER_RES");
	}
}

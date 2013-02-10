// MESSAGE FILE_TRANSFER_DIR_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
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
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST;
		packet.payload.putLong(transfer_uid);
		 for (int i = 0; i < dir_path.length; i++) {
                        packet.payload.putByte(dir_path[i]);
            }
		packet.payload.putByte(flags);
		return packet;		
	}

    /**
     * Decode a file_transfer_dir_list message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    transfer_uid = payload.getLong();
	     for (int i = 0; i < dir_path.length; i++) {
			dir_path[i] = payload.getByte();
		}
	    flags = payload.getByte();    
    }

     /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_param_request_list(){
    	msgid = MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_file_transfer_dir_list(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST;
        unpack(payload);
        Log.d("MAVLink", "FILE_TRANSFER_DIR_LIST");
        //Log.d("MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST -"+" transfer_uid:"+transfer_uid+" dir_path:"+dir_path+" flags:"+flags+"";
    }
}

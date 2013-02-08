// MESSAGE DATA96 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Data packet, size 96
*/
public class msg_data96 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA96 = 172;
	public static final int MAVLINK_MSG_LENGTH = 98;

 	/**
	*data type
	*/
	public byte type; 
 	/**
	*data length
	*/
	public byte len; 
 	/**
	*raw data
	*/
	public byte data[] = new byte[96]; 

/**
 * Decode a data96 message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    type = payload.getByte();
	    len = payload.getByte();
	     for (int i = 0; i < data.length; i++) {
			data[i] = payload.getByte();
		}    
    }

    public msg_data96(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_DATA96;
        unpack(payload);
        Log.d("MAVLink", "DATA96");
    }
}

// MESSAGE DATA64 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Data packet, size 64
*/
public class msg_data64 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA64 = 171;
	public static final int MAVLINK_MSG_LENGTH = 66;

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
	public byte data[] = new byte[64]; 

/**
 * Decode a data64 message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.type = payload.getbyte();
	//m.len = payload.getbyte();
	// = payload.getbyte();
    
    }

    public msg_data64(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "DATA64");
	}
}

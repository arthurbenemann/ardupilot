// MESSAGE DATA32 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Data packet, size 32
*/
public class msg_data32 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA32 = 170;
	public static final int MAVLINK_MSG_LENGTH = 34;

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
	public byte data[] = new byte[32]; 

/**
 * Decode a data32 message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.type = payload.getbyte();
	//m.len = payload.getbyte();
	// = payload.getbyte();
    
    }

    public msg_data32(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "DATA32");
	}
}

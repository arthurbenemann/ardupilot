// MESSAGE DATA16 PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Data packet, size 16
*/
public class msg_data16 extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DATA16 = 169;
	public static final int MAVLINK_MSG_LENGTH = 18;

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
	public byte data[] = new byte[16]; 

/**
 * Decode a data16 message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//type = payload.getByte();
	//len = payload.getByte();
	// = payload.getByte();
    
    }

    public msg_data16(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_DATA16;
    unpack(payload);
    Log.d("MAVLink", "DATA16");
    }
}

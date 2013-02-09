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
        payload.resetIndex();
	    type = payload.getByte();
	    len = payload.getByte();
	     for (int i = 0; i < data.length; i++) {
			data[i] = payload.getByte();
		}    
    }

    public msg_data32(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_DATA32;
        unpack(payload);
        Log.d("MAVLink", "DATA32");
        //Log.d("MAVLINK_MSG_ID_DATA32", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_DATA32 -"+" type:"+type+" len:"+len+" data:"+data+"";
    }
}

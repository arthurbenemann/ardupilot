// MESSAGE NAMED_VALUE_FLOAT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Send a key-value pair as float. The use of this message is discouraged for normal packets, but a quite efficient way for testing new messages and getting experimental debug output.
*/
public class msg_named_value_float extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT = 251;
	public static final int MAVLINK_MSG_LENGTH = 18;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*Floating point value
	*/
	public float value; 
 	/**
	*Name of the debug variable
	*/
	public byte name[] = new byte[10]; 

/**
 * Decode a named_value_float message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_boot_ms = payload.getInt();
	    value = payload.getFloat();
	     for (int i = 0; i < name.length; i++) {
			name[i] = payload.getByte();
		}    
    }

    public msg_named_value_float(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;
        unpack(payload);
        Log.d("MAVLink", "NAMED_VALUE_FLOAT");
        //Log.d("MAVLINK_MSG_ID_NAMED_VALUE_FLOAT", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT -"+" time_boot_ms:"+time_boot_ms+" value:"+value+" name:"+name+"";
    }
}

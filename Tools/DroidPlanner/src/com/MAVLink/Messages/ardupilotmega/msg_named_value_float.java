// MESSAGE NAMED_VALUE_FLOAT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
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
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;
		packet.len = MAVLINK_MSG_LENGTH;
		packet.payload.putInt(time_boot_ms);
		packet.payload.putFloat(value);
		 for (int i = 0; i < name.length; i++) {
                        packet.payload.putByte(name[i]);
            }
		return packet;		
	}

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

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_named_value_float(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;
        unpack(payload);
        Log.d("MAVLink", "NAMED_VALUE_FLOAT");
        //Log.d("MAVLINK_MSG_ID_NAMED_VALUE_FLOAT", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_NAMED_VALUE_FLOAT -"+" time_boot_ms:"+time_boot_ms+" value:"+value+" name:"+name+"";
    }
}

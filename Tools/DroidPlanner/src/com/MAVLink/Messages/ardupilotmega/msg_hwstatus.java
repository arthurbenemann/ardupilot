// MESSAGE HWSTATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Status of key hardware
*/
public class msg_hwstatus extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HWSTATUS = 165;
	public static final int MAVLINK_MSG_LENGTH = 3;

 	/**
	*board voltage (mV)
	*/
	public short Vcc; 
 	/**
	*I2C error count
	*/
	public byte I2Cerr; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_HWSTATUS;
		packet.len = MAVLINK_MSG_LENGTH;
		packet.payload.putShort(Vcc);
		packet.payload.putByte(I2Cerr);
		return packet;		
	}

    /**
     * Decode a hwstatus message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    Vcc = payload.getShort();
	    I2Cerr = payload.getByte();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_hwstatus(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_HWSTATUS;
        unpack(payload);
        Log.d("MAVLink", "HWSTATUS");
        //Log.d("MAVLINK_MSG_ID_HWSTATUS", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_HWSTATUS -"+" Vcc:"+Vcc+" I2Cerr:"+I2Cerr+"";
    }
}

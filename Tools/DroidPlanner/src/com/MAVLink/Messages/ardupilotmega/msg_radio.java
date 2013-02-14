// MESSAGE RADIO PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Status generated by radio
*/
public class msg_radio extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RADIO = 166;
	public static final int MAVLINK_MSG_LENGTH = 9;
	private static final long serialVersionUID = MAVLINK_MSG_ID_RADIO;
	

 	/**
	*receive errors
	*/
	public short rxerrors; 
 	/**
	*count of error corrected packets
	*/
	public short fixed; 
 	/**
	*local signal strength
	*/
	public byte rssi; 
 	/**
	*remote signal strength
	*/
	public byte remrssi; 
 	/**
	*how full the tx buffer is as a percentage
	*/
	public byte txbuf; 
 	/**
	*background noise level
	*/
	public byte noise; 
 	/**
	*remote background noise level
	*/
	public byte remnoise; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_RADIO;
		packet.payload.putShort(rxerrors);
		packet.payload.putShort(fixed);
		packet.payload.putByte(rssi);
		packet.payload.putByte(remrssi);
		packet.payload.putByte(txbuf);
		packet.payload.putByte(noise);
		packet.payload.putByte(remnoise);
		return packet;		
	}

    /**
     * Decode a radio message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    rxerrors = payload.getShort();
	    fixed = payload.getShort();
	    rssi = payload.getByte();
	    remrssi = payload.getByte();
	    txbuf = payload.getByte();
	    noise = payload.getByte();
	    remnoise = payload.getByte();    
    }

     /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_radio(){
    	msgid = MAVLINK_MSG_ID_RADIO;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_radio(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_RADIO;
        unpack(payload);
        Log.d("MAVLink", "RADIO");
        //Log.d("MAVLINK_MSG_ID_RADIO", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_RADIO -"+" rxerrors:"+rxerrors+" fixed:"+fixed+" rssi:"+rssi+" remrssi:"+remrssi+" txbuf:"+txbuf+" noise:"+noise+" remnoise:"+remnoise+"";
    }
}

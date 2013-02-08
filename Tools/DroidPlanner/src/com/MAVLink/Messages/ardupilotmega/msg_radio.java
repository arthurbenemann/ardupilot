// MESSAGE RADIO PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Status generated by radio
*/
public class msg_radio extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RADIO = 166;
	public static final int MAVLINK_MSG_LENGTH = 9;

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
 * Decode a radio message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.rxerrors = payload.getshort();
	//m.fixed = payload.getshort();
	//m.rssi = payload.getbyte();
	//m.remrssi = payload.getbyte();
	//m.txbuf = payload.getbyte();
	//m.noise = payload.getbyte();
	//m.remnoise = payload.getbyte();
    
    }

    public msg_radio(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "RADIO");
	}
}

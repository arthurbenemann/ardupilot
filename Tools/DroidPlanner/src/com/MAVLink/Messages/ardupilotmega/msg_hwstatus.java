// MESSAGE HWSTATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
 * Decode a hwstatus message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.Vcc = payload.getshort();
	//m.I2Cerr = payload.getbyte();
    
    }
}

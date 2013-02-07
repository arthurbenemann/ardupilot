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
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_hwstatus m = new msg_hwstatus();
	//m.Vcc = _get_Vcc(msg);
	//m.I2Cerr = _get_I2Cerr(msg);
    return m;	

    }
}

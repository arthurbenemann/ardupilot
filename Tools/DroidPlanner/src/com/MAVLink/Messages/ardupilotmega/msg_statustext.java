// MESSAGE STATUSTEXT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Status text message. These messages are printed in yellow in the COMM console of QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status and error messages. If implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10 Hz).
*/
public class msg_statustext extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_STATUSTEXT = 253;
	public static final int MAVLINK_MSG_LENGTH = 51;

 	/**
	*Severity of status. Relies on the definitions within RFC-5424. See enum MAV_SEVERITY.
	*/
	public byte severity; 
 	/**
	*Status text message, without null termination character
	*/
	public byte text[] = new byte[50]; 

/**
 * Decode a statustext message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.severity = payload.getbyte();
	// = payload.getbyte();
    
    }
}

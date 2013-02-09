// MESSAGE STATUSTEXT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    severity = payload.getByte();
	     for (int i = 0; i < text.length; i++) {
			text[i] = payload.getByte();
		}    
    }

    public msg_statustext(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_STATUSTEXT;
        unpack(payload);
        Log.d("MAVLink", "STATUSTEXT");
        //Log.d("MAVLINK_MSG_ID_STATUSTEXT", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_STATUSTEXT -"+" severity:"+severity+" text:"+text+"";
    }
}

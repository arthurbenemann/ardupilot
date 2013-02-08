// MESSAGE SYSTEM_TIME PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The system time is the time of the master clock, typically the computer clock of the main onboard computer.
*/
public class msg_system_time extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SYSTEM_TIME = 2;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*Timestamp of the master clock in microseconds since UNIX epoch.
	*/
	public long time_unix_usec; 
 	/**
	*Timestamp of the component clock since boot time in milliseconds.
	*/
	public int time_boot_ms; 

/**
 * Decode a system_time message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    time_unix_usec = payload.getLong();
	    time_boot_ms = payload.getInt();    
    }

    public msg_system_time(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SYSTEM_TIME;
        unpack(payload);
        Log.d("MAVLink", "SYSTEM_TIME");
    }
}

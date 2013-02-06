// MESSAGE SYSTEM_TIME PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_system_time m = new msg_system_time();
	//m.time_unix_usec = _get_time_unix_usec(msg);
	//m.time_boot_ms = _get_time_boot_ms(msg);
    return m;	

    }
}

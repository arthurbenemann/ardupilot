// MESSAGE PING PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* A ping message either requesting or responding to a ping. This allows to measure the system latencies, including serial port, radio modem and UDP connections.
*/
public class msg_ping extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PING = 4;
	public static final int MAVLINK_MSG_LENGTH = 14;

 	/**
	*Unix timestamp in microseconds
	*/
	public long time_usec; 
 	/**
	*PING sequence
	*/
	public int seq; 
 	/**
	*0: request ping from all receiving systems, if greater than 0: message is a ping response and number is the system id of the requesting system
	*/
	public byte target_system; 
 	/**
	*0: request ping from all receiving components, if greater than 0: message is a ping response and number is the system id of the requesting system
	*/
	public byte target_component; 

/**
 * Decode a ping message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_ping m = new msg_ping();
	//m.time_usec = _get_time_usec(msg);
	//m.seq = _get_seq(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

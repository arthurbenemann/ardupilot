// MESSAGE OMNIDIRECTIONAL_FLOW PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* Optical flow from an omnidirectional flow sensor (e.g. PX4FLOW with wide angle lens)
*/
public class msg_omnidirectional_flow extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_OMNIDIRECTIONAL_FLOW = 106;
	public static final int MAVLINK_MSG_LENGTH = 54;

 	/**
	*Timestamp (microseconds, synced to UNIX time or since system boot)
	*/
	public long time_usec; 
 	/**
	*Front distance in meters. Positive value (including zero): distance known. Negative value: Unknown distance
	*/
	public float front_distance_m; 
 	/**
	*Flow in deci pixels (1 = 0.1 pixel) on left hemisphere
	*/
	public short left[] = new short[10]; 
 	/**
	*Flow in deci pixels (1 = 0.1 pixel) on right hemisphere
	*/
	public short right[] = new short[10]; 
 	/**
	*Sensor ID
	*/
	public byte sensor_id; 
 	/**
	*Optical flow quality / confidence. 0: bad, 255: maximum quality
	*/
	public byte quality; 

/**
 * Decode a omnidirectional_flow message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_omnidirectional_flow m = new msg_omnidirectional_flow();
	//m.time_usec = _get_time_usec(msg);
	//m.front_distance_m = _get_front_distance_m(msg);
	// = _get_left(msgm.left);
	// = _get_right(msgm.right);
	//m.sensor_id = _get_sensor_id(msg);
	//m.quality = _get_quality(msg);
    return m;	

    }
}

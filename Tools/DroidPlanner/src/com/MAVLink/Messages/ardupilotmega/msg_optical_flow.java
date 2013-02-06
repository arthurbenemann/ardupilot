// MESSAGE OPTICAL_FLOW PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Optical flow from a flow sensor (e.g. optical mouse sensor)
*/
public class msg_optical_flow extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_OPTICAL_FLOW = 100;
	public static final int MAVLINK_MSG_LENGTH = 26;

 	/**
	*Timestamp (UNIX)
	*/
	public long time_usec; 
 	/**
	*Flow in meters in x-sensor direction, angular-speed compensated
	*/
	public float flow_comp_m_x; 
 	/**
	*Flow in meters in y-sensor direction, angular-speed compensated
	*/
	public float flow_comp_m_y; 
 	/**
	*Ground distance in meters. Positive value: distance known. Negative value: Unknown distance
	*/
	public float ground_distance; 
 	/**
	*Flow in pixels in x-sensor direction
	*/
	public short flow_x; 
 	/**
	*Flow in pixels in y-sensor direction
	*/
	public short flow_y; 
 	/**
	*Sensor ID
	*/
	public byte sensor_id; 
 	/**
	*Optical flow quality / confidence. 0: bad, 255: maximum quality
	*/
	public byte quality; 


/**
 * Decode a optical_flow message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_optical_flow m = new msg_optical_flow();
	//m.time_usec = _get_time_usec(msg);
	//m.flow_comp_m_x = _get_flow_comp_m_x(msg);
	//m.flow_comp_m_y = _get_flow_comp_m_y(msg);
	//m.ground_distance = _get_ground_distance(msg);
	//m.flow_x = _get_flow_x(msg);
	//m.flow_y = _get_flow_y(msg);
	//m.sensor_id = _get_sensor_id(msg);
	//m.quality = _get_quality(msg);
    return m;	

    }
}

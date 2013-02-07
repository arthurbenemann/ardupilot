// MESSAGE FENCE_POINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* A fence point. Used to set a point when from
	      GCS -> MAV. Also used to return a point from MAV -> GCS
*/
public class msg_fence_point extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_FENCE_POINT = 160;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*Latitude of point
	*/
	public float lat; 
 	/**
	*Longitude of point
	*/
	public float lng; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*point index (first point is 1, 0 is for return point)
	*/
	public byte idx; 
 	/**
	*total number of points (for sanity checking)
	*/
	public byte count; 

/**
 * Decode a fence_point message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_fence_point m = new msg_fence_point();
	//m.lat = _get_lat(msg);
	//m.lng = _get_lng(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
	//m.idx = _get_idx(msg);
	//m.count = _get_count(msg);
    return m;	

    }
}

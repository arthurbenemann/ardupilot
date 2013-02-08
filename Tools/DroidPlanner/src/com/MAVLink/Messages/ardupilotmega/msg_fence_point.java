// MESSAGE FENCE_POINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.lat = payload.getfloat();
	//m.lng = payload.getfloat();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
	//m.idx = payload.getbyte();
	//m.count = payload.getbyte();
    
    }
}

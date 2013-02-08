// MESSAGE FENCE_POINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    lat = payload.getFloat();
	    lng = payload.getFloat();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    idx = payload.getByte();
	    count = payload.getByte();    
    }

    public msg_fence_point(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_FENCE_POINT;
        unpack(payload);
        Log.d("MAVLink", "FENCE_POINT");
    }
}

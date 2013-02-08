// MESSAGE OPTICAL_FLOW PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_usec = payload.getLong();
	    flow_comp_m_x = payload.getFloat();
	    flow_comp_m_y = payload.getFloat();
	    ground_distance = payload.getFloat();
	    flow_x = payload.getShort();
	    flow_y = payload.getShort();
	    sensor_id = payload.getByte();
	    quality = payload.getByte();    
    }

    public msg_optical_flow(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_OPTICAL_FLOW;
        unpack(payload);
        Log.d("MAVLink", "OPTICAL_FLOW");
    }
}

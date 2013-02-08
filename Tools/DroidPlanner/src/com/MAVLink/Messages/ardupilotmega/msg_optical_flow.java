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
	//m.time_usec = payload.getlong();
	//m.flow_comp_m_x = payload.getfloat();
	//m.flow_comp_m_y = payload.getfloat();
	//m.ground_distance = payload.getfloat();
	//m.flow_x = payload.getshort();
	//m.flow_y = payload.getshort();
	//m.sensor_id = payload.getbyte();
	//m.quality = payload.getbyte();
    
    }

    public msg_optical_flow(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "OPTICAL_FLOW");
	}
}

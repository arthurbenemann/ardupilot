// MESSAGE SAFETY_ALLOWED_AREA PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Read out the safety zone the MAV currently assumes.
*/
public class msg_safety_allowed_area extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SAFETY_ALLOWED_AREA = 55;
	public static final int MAVLINK_MSG_LENGTH = 25;

 	/**
	*x position 1 / Latitude 1
	*/
	public float p1x; 
 	/**
	*y position 1 / Longitude 1
	*/
	public float p1y; 
 	/**
	*z position 1 / Altitude 1
	*/
	public float p1z; 
 	/**
	*x position 2 / Latitude 2
	*/
	public float p2x; 
 	/**
	*y position 2 / Longitude 2
	*/
	public float p2y; 
 	/**
	*z position 2 / Altitude 2
	*/
	public float p2z; 
 	/**
	*Coordinate frame, as defined by MAV_FRAME enum in mavlink_types.h. Can be either global, GPS, right-handed with Z axis up or local, right handed, Z axis down.
	*/
	public byte frame; 

/**
 * Decode a safety_allowed_area message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//p1x = payload.getFloat();
	//p1y = payload.getFloat();
	//p1z = payload.getFloat();
	//p2x = payload.getFloat();
	//p2y = payload.getFloat();
	//p2z = payload.getFloat();
	//frame = payload.getByte();
    
    }

    public msg_safety_allowed_area(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_SAFETY_ALLOWED_AREA;
    unpack(payload);
    Log.d("MAVLink", "SAFETY_ALLOWED_AREA");
    }
}

// MESSAGE GPS_GLOBAL_ORIGIN PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Once the MAV sets a new GPS-Local correspondence, this message announces the origin (0,0,0) position
*/
public class msg_gps_global_origin extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GPS_GLOBAL_ORIGIN = 49;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*Latitude (WGS84), expressed as * 1E7
	*/
	public int latitude; 
 	/**
	*Longitude (WGS84), expressed as * 1E7
	*/
	public int longitude; 
 	/**
	*Altitude(WGS84), expressed as * 1000
	*/
	public int altitude; 

/**
 * Decode a gps_global_origin message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    latitude = payload.getInt();
	    longitude = payload.getInt();
	    altitude = payload.getInt();    
    }

    public msg_gps_global_origin(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_GPS_GLOBAL_ORIGIN;
        unpack(payload);
        Log.d("MAVLink", "GPS_GLOBAL_ORIGIN");
    }
}

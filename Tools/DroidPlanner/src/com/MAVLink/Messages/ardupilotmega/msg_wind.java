// MESSAGE WIND PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Wind estimation
*/
public class msg_wind extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_WIND = 168;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*wind direction that wind is coming from (degrees)
	*/
	public float direction; 
 	/**
	*wind speed in ground plane (m/s)
	*/
	public float speed; 
 	/**
	*vertical wind speed (m/s)
	*/
	public float speed_z; 

/**
 * Decode a wind message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    direction = payload.getFloat();
	    speed = payload.getFloat();
	    speed_z = payload.getFloat();    
    }

    public msg_wind(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_WIND;
        unpack(payload);
        Log.d("MAVLink", "WIND");
        //Log.d("MAVLINK_MSG_ID_WIND", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_WIND -"+" direction:"+direction+" speed:"+speed+" speed_z:"+speed_z+"";
    }
}

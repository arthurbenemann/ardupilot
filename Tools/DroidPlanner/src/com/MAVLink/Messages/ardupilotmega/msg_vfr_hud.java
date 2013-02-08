// MESSAGE VFR_HUD PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Metrics typically displayed on a HUD for fixed wing aircraft
*/
public class msg_vfr_hud extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_VFR_HUD = 74;
	public static final int MAVLINK_MSG_LENGTH = 20;

 	/**
	*Current airspeed in m/s
	*/
	public float airspeed; 
 	/**
	*Current ground speed in m/s
	*/
	public float groundspeed; 
 	/**
	*Current altitude (MSL), in meters
	*/
	public float alt; 
 	/**
	*Current climb rate in meters/second
	*/
	public float climb; 
 	/**
	*Current heading in degrees, in compass units (0..360, 0=north)
	*/
	public short heading; 
 	/**
	*Current throttle setting in integer percent, 0 to 100
	*/
	public short throttle; 

/**
 * Decode a vfr_hud message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    airspeed = payload.getFloat();
	    groundspeed = payload.getFloat();
	    alt = payload.getFloat();
	    climb = payload.getFloat();
	    heading = payload.getShort();
	    throttle = payload.getShort();    
    }

    public msg_vfr_hud(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_VFR_HUD;
        unpack(payload);
        Log.d("MAVLink", "VFR_HUD");
    }
}

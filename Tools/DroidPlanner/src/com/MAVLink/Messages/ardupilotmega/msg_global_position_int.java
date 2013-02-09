// MESSAGE GLOBAL_POSITION_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It
               is designed as scaled integer message since the resolution of float is not sufficient.
*/
public class msg_global_position_int extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_INT = 33;
	public static final int MAVLINK_MSG_LENGTH = 28;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*Latitude, expressed as * 1E7
	*/
	public int lat; 
 	/**
	*Longitude, expressed as * 1E7
	*/
	public int lon; 
 	/**
	*Altitude in meters, expressed as * 1000 (millimeters), above MSL
	*/
	public int alt; 
 	/**
	*Altitude above ground in meters, expressed as * 1000 (millimeters)
	*/
	public int relative_alt; 
 	/**
	*Ground X Speed (Latitude), expressed as m/s * 100
	*/
	public short vx; 
 	/**
	*Ground Y Speed (Longitude), expressed as m/s * 100
	*/
	public short vy; 
 	/**
	*Ground Z Speed (Altitude), expressed as m/s * 100
	*/
	public short vz; 
 	/**
	*Compass heading in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 65535
	*/
	public short hdg; 

/**
 * Decode a global_position_int message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_boot_ms = payload.getInt();
	    lat = payload.getInt();
	    lon = payload.getInt();
	    alt = payload.getInt();
	    relative_alt = payload.getInt();
	    vx = payload.getShort();
	    vy = payload.getShort();
	    vz = payload.getShort();
	    hdg = payload.getShort();    
    }

    public msg_global_position_int(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_GLOBAL_POSITION_INT;
        unpack(payload);
        Log.d("MAVLink", "GLOBAL_POSITION_INT");
        //Log.d("MAVLINK_MSG_ID_GLOBAL_POSITION_INT", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_GLOBAL_POSITION_INT -"+" time_boot_ms:"+time_boot_ms+" lat:"+lat+" lon:"+lon+" alt:"+alt+" relative_alt:"+relative_alt+" vx:"+vx+" vy:"+vy+" vz:"+vz+" hdg:"+hdg+"";
    }
}

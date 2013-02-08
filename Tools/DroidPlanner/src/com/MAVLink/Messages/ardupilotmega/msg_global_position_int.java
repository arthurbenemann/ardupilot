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
	//m.time_boot_ms = payload.getint();
	//m.lat = payload.getint();
	//m.lon = payload.getint();
	//m.alt = payload.getint();
	//m.relative_alt = payload.getint();
	//m.vx = payload.getshort();
	//m.vy = payload.getshort();
	//m.vz = payload.getshort();
	//m.hdg = payload.getshort();
    
    }

    public msg_global_position_int(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "GLOBAL_POSITION_INT");
	}
}

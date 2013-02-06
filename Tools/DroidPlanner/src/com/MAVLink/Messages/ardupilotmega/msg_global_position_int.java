// MESSAGE GLOBAL_POSITION_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_global_position_int m = new msg_global_position_int();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.lat = _get_lat(msg);
	//m.lon = _get_lon(msg);
	//m.alt = _get_alt(msg);
	//m.relative_alt = _get_relative_alt(msg);
	//m.vx = _get_vx(msg);
	//m.vy = _get_vy(msg);
	//m.vz = _get_vz(msg);
	//m.hdg = _get_hdg(msg);
    return m;	

    }
}

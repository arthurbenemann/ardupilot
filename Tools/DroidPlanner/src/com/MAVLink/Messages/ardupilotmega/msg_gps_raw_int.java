// MESSAGE GPS_RAW_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* The global position, as returned by the Global Positioning System (GPS). This is
                NOT the global position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate. Coordinate frame is right-handed, Z-axis up (GPS frame).
*/
public class msg_gps_raw_int extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GPS_RAW_INT = 24;
	public static final int MAVLINK_MSG_LENGTH = 30;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*Latitude in 1E7 degrees
	*/
	public int lat; 
 	/**
	*Longitude in 1E7 degrees
	*/
	public int lon; 
 	/**
	*Altitude in 1E3 meters (millimeters) above MSL
	*/
	public int alt; 
 	/**
	*GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535
	*/
	public short eph; 
 	/**
	*GPS VDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535
	*/
	public short epv; 
 	/**
	*GPS ground speed (m/s * 100). If unknown, set to: 65535
	*/
	public short vel; 
 	/**
	*Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 65535
	*/
	public short cog; 
 	/**
	*0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix.
	*/
	public byte fix_type; 
 	/**
	*Number of satellites visible. If unknown, set to 255
	*/
	public byte satellites_visible; 

/**
 * Decode a gps_raw_int message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_gps_raw_int m = new msg_gps_raw_int();
	//m.time_usec = _get_time_usec(msg);
	//m.lat = _get_lat(msg);
	//m.lon = _get_lon(msg);
	//m.alt = _get_alt(msg);
	//m.eph = _get_eph(msg);
	//m.epv = _get_epv(msg);
	//m.vel = _get_vel(msg);
	//m.cog = _get_cog(msg);
	//m.fix_type = _get_fix_type(msg);
	//m.satellites_visible = _get_satellites_visible(msg);
    return m;	

    }
}

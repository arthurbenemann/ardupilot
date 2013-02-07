// MESSAGE GPS_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The positioning status, as reported by GPS. This message is intended to display status information about each satellite visible to the receiver. See message GLOBAL_POSITION for the global position estimate. This message can contain information for up to 20 satellites.
*/
public class msg_gps_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GPS_STATUS = 25;
	public static final int MAVLINK_MSG_LENGTH = 101;

 	/**
	*Number of satellites visible
	*/
	public byte satellites_visible; 
 	/**
	*Global satellite ID
	*/
	public byte satellite_prn[] = new byte[20]; 
 	/**
	*0: Satellite not used, 1: used for localization
	*/
	public byte satellite_used[] = new byte[20]; 
 	/**
	*Elevation (0: right on top of receiver, 90: on the horizon) of satellite
	*/
	public byte satellite_elevation[] = new byte[20]; 
 	/**
	*Direction of satellite, 0: 0 deg, 255: 360 deg.
	*/
	public byte satellite_azimuth[] = new byte[20]; 
 	/**
	*Signal to noise ratio of satellite
	*/
	public byte satellite_snr[] = new byte[20]; 

/**
 * Decode a gps_status message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_gps_status m = new msg_gps_status();
	//m.satellites_visible = _get_satellites_visible(msg);
	// = _get_satellite_prn(msgm.satellite_prn);
	// = _get_satellite_used(msgm.satellite_used);
	// = _get_satellite_elevation(msgm.satellite_elevation);
	// = _get_satellite_azimuth(msgm.satellite_azimuth);
	// = _get_satellite_snr(msgm.satellite_snr);
    return m;	

    }
}

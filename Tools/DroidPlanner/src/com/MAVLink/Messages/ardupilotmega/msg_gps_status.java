// MESSAGE GPS_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    satellites_visible = payload.getByte();
	     for (int i = 0; i < satellite_prn.length; i++) {
			satellite_prn[i] = payload.getByte();
		}
	     for (int i = 0; i < satellite_used.length; i++) {
			satellite_used[i] = payload.getByte();
		}
	     for (int i = 0; i < satellite_elevation.length; i++) {
			satellite_elevation[i] = payload.getByte();
		}
	     for (int i = 0; i < satellite_azimuth.length; i++) {
			satellite_azimuth[i] = payload.getByte();
		}
	     for (int i = 0; i < satellite_snr.length; i++) {
			satellite_snr[i] = payload.getByte();
		}    
    }

    public msg_gps_status(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_GPS_STATUS;
        unpack(payload);
        Log.d("MAVLink", "GPS_STATUS");
    }
}

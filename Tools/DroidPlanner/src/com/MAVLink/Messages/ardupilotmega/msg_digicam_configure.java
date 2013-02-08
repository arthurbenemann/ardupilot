// MESSAGE DIGICAM_CONFIGURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Configure on-board Camera Control System.
*/
public class msg_digicam_configure extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_DIGICAM_CONFIGURE = 154;
	public static final int MAVLINK_MSG_LENGTH = 15;

 	/**
	*Correspondent value to given extra_param
	*/
	public float extra_value; 
 	/**
	*Divisor number //e.g. 1000 means 1/1000 (0 means ignore)
	*/
	public short shutter_speed; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore)
	*/
	public byte mode; 
 	/**
	*F stop number x 10 //e.g. 28 means 2.8 (0 means ignore)
	*/
	public byte aperture; 
 	/**
	*ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore)
	*/
	public byte iso; 
 	/**
	*Exposure type enumeration from 1 to N (0 means ignore)
	*/
	public byte exposure_type; 
 	/**
	*Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed or pooled just once
	*/
	public byte command_id; 
 	/**
	*Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off)
	*/
	public byte engine_cut_off; 
 	/**
	*Extra parameters enumeration (0 means ignore)
	*/
	public byte extra_param; 

/**
 * Decode a digicam_configure message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.extra_value = payload.getfloat();
	//m.shutter_speed = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
	//m.mode = payload.getbyte();
	//m.aperture = payload.getbyte();
	//m.iso = payload.getbyte();
	//m.exposure_type = payload.getbyte();
	//m.command_id = payload.getbyte();
	//m.engine_cut_off = payload.getbyte();
	//m.extra_param = payload.getbyte();
    
    }

    public msg_digicam_configure(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "DIGICAM_CONFIGURE");
	}
}

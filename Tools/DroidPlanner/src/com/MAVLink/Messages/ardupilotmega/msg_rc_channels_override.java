// MESSAGE RC_CHANNELS_OVERRIDE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The RAW values of the RC channels sent to the MAV to override info received from the RC radio. A value of -1 means no change to that channel. A value of 0 means control of that channel should be released back to the RC radio. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.
*/
public class msg_rc_channels_override extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE = 70;
	public static final int MAVLINK_MSG_LENGTH = 18;

 	/**
	*RC channel 1 value, in microseconds
	*/
	public short chan1_raw; 
 	/**
	*RC channel 2 value, in microseconds
	*/
	public short chan2_raw; 
 	/**
	*RC channel 3 value, in microseconds
	*/
	public short chan3_raw; 
 	/**
	*RC channel 4 value, in microseconds
	*/
	public short chan4_raw; 
 	/**
	*RC channel 5 value, in microseconds
	*/
	public short chan5_raw; 
 	/**
	*RC channel 6 value, in microseconds
	*/
	public short chan6_raw; 
 	/**
	*RC channel 7 value, in microseconds
	*/
	public short chan7_raw; 
 	/**
	*RC channel 8 value, in microseconds
	*/
	public short chan8_raw; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 

/**
 * Decode a rc_channels_override message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.chan1_raw = payload.getshort();
	//m.chan2_raw = payload.getshort();
	//m.chan3_raw = payload.getshort();
	//m.chan4_raw = payload.getshort();
	//m.chan5_raw = payload.getshort();
	//m.chan6_raw = payload.getshort();
	//m.chan7_raw = payload.getshort();
	//m.chan8_raw = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
    
    }

    public msg_rc_channels_override(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "RC_CHANNELS_OVERRIDE");
	}
}

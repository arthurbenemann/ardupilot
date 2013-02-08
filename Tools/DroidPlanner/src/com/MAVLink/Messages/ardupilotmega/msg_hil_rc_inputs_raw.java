// MESSAGE HIL_RC_INPUTS_RAW PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.
*/
public class msg_hil_rc_inputs_raw extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW = 92;
	public static final int MAVLINK_MSG_LENGTH = 33;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
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
	*RC channel 9 value, in microseconds
	*/
	public short chan9_raw; 
 	/**
	*RC channel 10 value, in microseconds
	*/
	public short chan10_raw; 
 	/**
	*RC channel 11 value, in microseconds
	*/
	public short chan11_raw; 
 	/**
	*RC channel 12 value, in microseconds
	*/
	public short chan12_raw; 
 	/**
	*Receive signal strength indicator, 0: 0%, 255: 100%
	*/
	public byte rssi; 

/**
 * Decode a hil_rc_inputs_raw message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//time_usec = payload.getLong();
	//chan1_raw = payload.getShort();
	//chan2_raw = payload.getShort();
	//chan3_raw = payload.getShort();
	//chan4_raw = payload.getShort();
	//chan5_raw = payload.getShort();
	//chan6_raw = payload.getShort();
	//chan7_raw = payload.getShort();
	//chan8_raw = payload.getShort();
	//chan9_raw = payload.getShort();
	//chan10_raw = payload.getShort();
	//chan11_raw = payload.getShort();
	//chan12_raw = payload.getShort();
	//rssi = payload.getByte();
    
    }

    public msg_hil_rc_inputs_raw(MAVLinkPayload payload){
    msgid = MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW;
    unpack(payload);
    Log.d("MAVLink", "HIL_RC_INPUTS_RAW");
    }
}

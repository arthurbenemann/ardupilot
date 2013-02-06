// MESSAGE HIL_RC_INPUTS_RAW PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_hil_rc_inputs_raw m = new msg_hil_rc_inputs_raw();
	//m.time_usec = _get_time_usec(msg);
	//m.chan1_raw = _get_chan1_raw(msg);
	//m.chan2_raw = _get_chan2_raw(msg);
	//m.chan3_raw = _get_chan3_raw(msg);
	//m.chan4_raw = _get_chan4_raw(msg);
	//m.chan5_raw = _get_chan5_raw(msg);
	//m.chan6_raw = _get_chan6_raw(msg);
	//m.chan7_raw = _get_chan7_raw(msg);
	//m.chan8_raw = _get_chan8_raw(msg);
	//m.chan9_raw = _get_chan9_raw(msg);
	//m.chan10_raw = _get_chan10_raw(msg);
	//m.chan11_raw = _get_chan11_raw(msg);
	//m.chan12_raw = _get_chan12_raw(msg);
	//m.rssi = _get_rssi(msg);
    return m;	

    }
}

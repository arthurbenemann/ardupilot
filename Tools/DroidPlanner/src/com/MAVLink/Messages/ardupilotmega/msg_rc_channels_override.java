// MESSAGE RC_CHANNELS_OVERRIDE PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_rc_channels_override m = new msg_rc_channels_override();
	//m.chan1_raw = _get_chan1_raw(msg);
	//m.chan2_raw = _get_chan2_raw(msg);
	//m.chan3_raw = _get_chan3_raw(msg);
	//m.chan4_raw = _get_chan4_raw(msg);
	//m.chan5_raw = _get_chan5_raw(msg);
	//m.chan6_raw = _get_chan6_raw(msg);
	//m.chan7_raw = _get_chan7_raw(msg);
	//m.chan8_raw = _get_chan8_raw(msg);
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

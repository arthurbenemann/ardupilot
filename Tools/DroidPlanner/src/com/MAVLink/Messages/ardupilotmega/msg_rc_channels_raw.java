// MESSAGE RC_CHANNELS_RAW PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might violate this specification.
*/
public class msg_rc_channels_raw extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RC_CHANNELS_RAW = 35;
	public static final int MAVLINK_MSG_LENGTH = 22;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*RC channel 1 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan1_raw; 
 	/**
	*RC channel 2 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan2_raw; 
 	/**
	*RC channel 3 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan3_raw; 
 	/**
	*RC channel 4 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan4_raw; 
 	/**
	*RC channel 5 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan5_raw; 
 	/**
	*RC channel 6 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan6_raw; 
 	/**
	*RC channel 7 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan7_raw; 
 	/**
	*RC channel 8 value, in microseconds. A value of 65535 implies the channel is unused.
	*/
	public short chan8_raw; 
 	/**
	*Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more than 8 servos.
	*/
	public byte port; 
 	/**
	*Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown.
	*/
	public byte rssi; 

/**
 * Decode a rc_channels_raw message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_rc_channels_raw m = new msg_rc_channels_raw();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.chan1_raw = _get_chan1_raw(msg);
	//m.chan2_raw = _get_chan2_raw(msg);
	//m.chan3_raw = _get_chan3_raw(msg);
	//m.chan4_raw = _get_chan4_raw(msg);
	//m.chan5_raw = _get_chan5_raw(msg);
	//m.chan6_raw = _get_chan6_raw(msg);
	//m.chan7_raw = _get_chan7_raw(msg);
	//m.chan8_raw = _get_chan8_raw(msg);
	//m.port = _get_port(msg);
	//m.rssi = _get_rssi(msg);
    return m;	

    }
}

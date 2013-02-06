// MESSAGE RC_CHANNELS_SCALED PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The scaled values of the RC channels received. (-100%) -10000, (0%) 0, (100%) 10000. Channels that are inactive should be set to 65535.
*/
public class msg_rc_channels_scaled extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RC_CHANNELS_SCALED = 34;
	public static final int MAVLINK_MSG_LENGTH = 22;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*RC channel 1 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan1_scaled; 
 	/**
	*RC channel 2 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan2_scaled; 
 	/**
	*RC channel 3 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan3_scaled; 
 	/**
	*RC channel 4 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan4_scaled; 
 	/**
	*RC channel 5 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan5_scaled; 
 	/**
	*RC channel 6 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan6_scaled; 
 	/**
	*RC channel 7 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan7_scaled; 
 	/**
	*RC channel 8 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) 32767.
	*/
	public short chan8_scaled; 
 	/**
	*Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more than 8 servos.
	*/
	public byte port; 
 	/**
	*Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown.
	*/
	public byte rssi; 


/**
 * Decode a rc_channels_scaled message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_rc_channels_scaled m = new msg_rc_channels_scaled();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.chan1_scaled = _get_chan1_scaled(msg);
	//m.chan2_scaled = _get_chan2_scaled(msg);
	//m.chan3_scaled = _get_chan3_scaled(msg);
	//m.chan4_scaled = _get_chan4_scaled(msg);
	//m.chan5_scaled = _get_chan5_scaled(msg);
	//m.chan6_scaled = _get_chan6_scaled(msg);
	//m.chan7_scaled = _get_chan7_scaled(msg);
	//m.chan8_scaled = _get_chan8_scaled(msg);
	//m.port = _get_port(msg);
	//m.rssi = _get_rssi(msg);
    return m;	

    }
}

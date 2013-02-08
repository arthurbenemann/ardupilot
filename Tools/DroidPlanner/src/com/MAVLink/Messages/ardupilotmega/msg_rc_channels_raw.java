// MESSAGE RC_CHANNELS_RAW PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
	    time_boot_ms = payload.getInt();
	    chan1_raw = payload.getShort();
	    chan2_raw = payload.getShort();
	    chan3_raw = payload.getShort();
	    chan4_raw = payload.getShort();
	    chan5_raw = payload.getShort();
	    chan6_raw = payload.getShort();
	    chan7_raw = payload.getShort();
	    chan8_raw = payload.getShort();
	    port = payload.getByte();
	    rssi = payload.getByte();    
    }

    public msg_rc_channels_raw(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_RC_CHANNELS_RAW;
        unpack(payload);
        Log.d("MAVLink", "RC_CHANNELS_RAW");
    }
}

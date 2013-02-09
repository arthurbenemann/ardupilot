// MESSAGE RC_CHANNELS_SCALED PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_boot_ms = payload.getInt();
	    chan1_scaled = payload.getShort();
	    chan2_scaled = payload.getShort();
	    chan3_scaled = payload.getShort();
	    chan4_scaled = payload.getShort();
	    chan5_scaled = payload.getShort();
	    chan6_scaled = payload.getShort();
	    chan7_scaled = payload.getShort();
	    chan8_scaled = payload.getShort();
	    port = payload.getByte();
	    rssi = payload.getByte();    
    }

    public msg_rc_channels_scaled(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_RC_CHANNELS_SCALED;
        unpack(payload);
        Log.d("MAVLink", "RC_CHANNELS_SCALED");
        //Log.d("MAVLINK_MSG_ID_RC_CHANNELS_SCALED", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_RC_CHANNELS_SCALED -"+" time_boot_ms:"+time_boot_ms+" chan1_scaled:"+chan1_scaled+" chan2_scaled:"+chan2_scaled+" chan3_scaled:"+chan3_scaled+" chan4_scaled:"+chan4_scaled+" chan5_scaled:"+chan5_scaled+" chan6_scaled:"+chan6_scaled+" chan7_scaled:"+chan7_scaled+" chan8_scaled:"+chan8_scaled+" port:"+port+" rssi:"+rssi+"";
    }
}

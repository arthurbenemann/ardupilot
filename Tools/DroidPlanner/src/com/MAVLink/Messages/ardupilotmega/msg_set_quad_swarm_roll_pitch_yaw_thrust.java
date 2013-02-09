// MESSAGE SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Setpoint for up to four quadrotors in a group / wing
*/
public class msg_set_quad_swarm_roll_pitch_yaw_thrust extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST = 61;
	public static final int MAVLINK_MSG_LENGTH = 34;

 	/**
	*Desired roll angle in radians +-PI (+-32767)
	*/
	public short roll[] = new short[4]; 
 	/**
	*Desired pitch angle in radians +-PI (+-32767)
	*/
	public short pitch[] = new short[4]; 
 	/**
	*Desired yaw angle in radians, scaled to int16 +-PI (+-32767)
	*/
	public short yaw[] = new short[4]; 
 	/**
	*Collective thrust, scaled to uint16 (0..65535)
	*/
	public short thrust[] = new short[4]; 
 	/**
	*ID of the quadrotor group (0 - 255, up to 256 groups supported)
	*/
	public byte group; 
 	/**
	*ID of the flight mode (0 - 255, up to 256 modes supported)
	*/
	public byte mode; 

/**
 * Decode a set_quad_swarm_roll_pitch_yaw_thrust message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	     for (int i = 0; i < roll.length; i++) {
			roll[i] = payload.getShort();
		}
	     for (int i = 0; i < pitch.length; i++) {
			pitch[i] = payload.getShort();
		}
	     for (int i = 0; i < yaw.length; i++) {
			yaw[i] = payload.getShort();
		}
	     for (int i = 0; i < thrust.length; i++) {
			thrust[i] = payload.getShort();
		}
	    group = payload.getByte();
	    mode = payload.getByte();    
    }

    public msg_set_quad_swarm_roll_pitch_yaw_thrust(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST;
        unpack(payload);
        Log.d("MAVLink", "SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST");
        //Log.d("MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST -"+" roll:"+roll+" pitch:"+pitch+" yaw:"+yaw+" thrust:"+thrust+" group:"+group+" mode:"+mode+"";
    }
}

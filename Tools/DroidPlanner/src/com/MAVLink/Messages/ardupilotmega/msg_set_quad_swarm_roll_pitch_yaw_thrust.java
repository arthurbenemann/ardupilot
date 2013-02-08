// MESSAGE SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	// = payload.getshort();
	// = payload.getshort();
	// = payload.getshort();
	// = payload.getshort();
	//m.group = payload.getbyte();
	//m.mode = payload.getbyte();
    
    }
}

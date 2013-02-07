// MESSAGE SET_QUAD_SWARM_LED_ROLL_PITCH_YAW_THRUST PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Setpoint for up to four quadrotors in a group / wing
*/
public class msg_set_quad_swarm_led_roll_pitch_yaw_thrust extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SET_QUAD_SWARM_LED_ROLL_PITCH_YAW_THRUST = 63;
	public static final int MAVLINK_MSG_LENGTH = 46;

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
	*RGB red channel (0-255)
	*/
	public byte led_red[] = new byte[4]; 
 	/**
	*RGB green channel (0-255)
	*/
	public byte led_blue[] = new byte[4]; 
 	/**
	*RGB blue channel (0-255)
	*/
	public byte led_green[] = new byte[4]; 

/**
 * Decode a set_quad_swarm_led_roll_pitch_yaw_thrust message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_set_quad_swarm_led_roll_pitch_yaw_thrust m = new msg_set_quad_swarm_led_roll_pitch_yaw_thrust();
	// = _get_roll(msgm.roll);
	// = _get_pitch(msgm.pitch);
	// = _get_yaw(msgm.yaw);
	// = _get_thrust(msgm.thrust);
	//m.group = _get_group(msg);
	//m.mode = _get_mode(msg);
	// = _get_led_red(msgm.led_red);
	// = _get_led_blue(msgm.led_blue);
	// = _get_led_green(msgm.led_green);
    return m;	

    }
}

// MESSAGE HIL_CONTROLS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Sent from autopilot to simulation. Hardware in the loop control outputs
*/
public class msg_hil_controls extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HIL_CONTROLS = 91;
	public static final int MAVLINK_MSG_LENGTH = 42;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*Control output -1 .. 1
	*/
	public float roll_ailerons; 
 	/**
	*Control output -1 .. 1
	*/
	public float pitch_elevator; 
 	/**
	*Control output -1 .. 1
	*/
	public float yaw_rudder; 
 	/**
	*Throttle 0 .. 1
	*/
	public float throttle; 
 	/**
	*Aux 1, -1 .. 1
	*/
	public float aux1; 
 	/**
	*Aux 2, -1 .. 1
	*/
	public float aux2; 
 	/**
	*Aux 3, -1 .. 1
	*/
	public float aux3; 
 	/**
	*Aux 4, -1 .. 1
	*/
	public float aux4; 
 	/**
	*System mode (MAV_MODE)
	*/
	public byte mode; 
 	/**
	*Navigation mode (MAV_NAV_MODE)
	*/
	public byte nav_mode; 

/**
 * Decode a hil_controls message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.time_usec = payload.getlong();
	//m.roll_ailerons = payload.getfloat();
	//m.pitch_elevator = payload.getfloat();
	//m.yaw_rudder = payload.getfloat();
	//m.throttle = payload.getfloat();
	//m.aux1 = payload.getfloat();
	//m.aux2 = payload.getfloat();
	//m.aux3 = payload.getfloat();
	//m.aux4 = payload.getfloat();
	//m.mode = payload.getbyte();
	//m.nav_mode = payload.getbyte();
    
    }

    public msg_hil_controls(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "HIL_CONTROLS");
	}
}

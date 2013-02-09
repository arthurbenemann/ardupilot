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
        payload.resetIndex();
	    time_usec = payload.getLong();
	    roll_ailerons = payload.getFloat();
	    pitch_elevator = payload.getFloat();
	    yaw_rudder = payload.getFloat();
	    throttle = payload.getFloat();
	    aux1 = payload.getFloat();
	    aux2 = payload.getFloat();
	    aux3 = payload.getFloat();
	    aux4 = payload.getFloat();
	    mode = payload.getByte();
	    nav_mode = payload.getByte();    
    }

    public msg_hil_controls(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_HIL_CONTROLS;
        unpack(payload);
        Log.d("MAVLink", "HIL_CONTROLS");
        //Log.d("MAVLINK_MSG_ID_HIL_CONTROLS", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_HIL_CONTROLS -"+" time_usec:"+time_usec+" roll_ailerons:"+roll_ailerons+" pitch_elevator:"+pitch_elevator+" yaw_rudder:"+yaw_rudder+" throttle:"+throttle+" aux1:"+aux1+" aux2:"+aux2+" aux3:"+aux3+" aux4:"+aux4+" mode:"+mode+" nav_mode:"+nav_mode+"";
    }
}

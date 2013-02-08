// MESSAGE HIL_STATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Sent from simulation to autopilot. This packet is useful for high throughput applications such as hardware in the loop simulations.
*/
public class msg_hil_state extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HIL_STATE = 90;
	public static final int MAVLINK_MSG_LENGTH = 56;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*Roll angle (rad)
	*/
	public float roll; 
 	/**
	*Pitch angle (rad)
	*/
	public float pitch; 
 	/**
	*Yaw angle (rad)
	*/
	public float yaw; 
 	/**
	*Roll angular speed (rad/s)
	*/
	public float rollspeed; 
 	/**
	*Pitch angular speed (rad/s)
	*/
	public float pitchspeed; 
 	/**
	*Yaw angular speed (rad/s)
	*/
	public float yawspeed; 
 	/**
	*Latitude, expressed as * 1E7
	*/
	public int lat; 
 	/**
	*Longitude, expressed as * 1E7
	*/
	public int lon; 
 	/**
	*Altitude in meters, expressed as * 1000 (millimeters)
	*/
	public int alt; 
 	/**
	*Ground X Speed (Latitude), expressed as m/s * 100
	*/
	public short vx; 
 	/**
	*Ground Y Speed (Longitude), expressed as m/s * 100
	*/
	public short vy; 
 	/**
	*Ground Z Speed (Altitude), expressed as m/s * 100
	*/
	public short vz; 
 	/**
	*X acceleration (mg)
	*/
	public short xacc; 
 	/**
	*Y acceleration (mg)
	*/
	public short yacc; 
 	/**
	*Z acceleration (mg)
	*/
	public short zacc; 

/**
 * Decode a hil_state message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    time_usec = payload.getLong();
	    roll = payload.getFloat();
	    pitch = payload.getFloat();
	    yaw = payload.getFloat();
	    rollspeed = payload.getFloat();
	    pitchspeed = payload.getFloat();
	    yawspeed = payload.getFloat();
	    lat = payload.getInt();
	    lon = payload.getInt();
	    alt = payload.getInt();
	    vx = payload.getShort();
	    vy = payload.getShort();
	    vz = payload.getShort();
	    xacc = payload.getShort();
	    yacc = payload.getShort();
	    zacc = payload.getShort();    
    }

    public msg_hil_state(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_HIL_STATE;
        unpack(payload);
        Log.d("MAVLink", "HIL_STATE");
    }
}

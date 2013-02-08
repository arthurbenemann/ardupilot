// MESSAGE SCALED_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled values to the described units
*/
public class msg_scaled_imu extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SCALED_IMU = 26;
	public static final int MAVLINK_MSG_LENGTH = 22;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
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
	*Angular speed around X axis (millirad /sec)
	*/
	public short xgyro; 
 	/**
	*Angular speed around Y axis (millirad /sec)
	*/
	public short ygyro; 
 	/**
	*Angular speed around Z axis (millirad /sec)
	*/
	public short zgyro; 
 	/**
	*X Magnetic field (milli tesla)
	*/
	public short xmag; 
 	/**
	*Y Magnetic field (milli tesla)
	*/
	public short ymag; 
 	/**
	*Z Magnetic field (milli tesla)
	*/
	public short zmag; 

/**
 * Decode a scaled_imu message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    time_boot_ms = payload.getInt();
	    xacc = payload.getShort();
	    yacc = payload.getShort();
	    zacc = payload.getShort();
	    xgyro = payload.getShort();
	    ygyro = payload.getShort();
	    zgyro = payload.getShort();
	    xmag = payload.getShort();
	    ymag = payload.getShort();
	    zmag = payload.getShort();    
    }

    public msg_scaled_imu(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SCALED_IMU;
        unpack(payload);
        Log.d("MAVLink", "SCALED_IMU");
    }
}

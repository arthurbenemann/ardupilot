// MESSAGE HIGHRES_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The IMU readings in SI units in NED body frame
*/
public class msg_highres_imu extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_HIGHRES_IMU = 105;
	public static final int MAVLINK_MSG_LENGTH = 62;

 	/**
	*Timestamp (microseconds, synced to UNIX time or since system boot)
	*/
	public long time_usec; 
 	/**
	*X acceleration (m/s^2)
	*/
	public float xacc; 
 	/**
	*Y acceleration (m/s^2)
	*/
	public float yacc; 
 	/**
	*Z acceleration (m/s^2)
	*/
	public float zacc; 
 	/**
	*Angular speed around X axis (rad / sec)
	*/
	public float xgyro; 
 	/**
	*Angular speed around Y axis (rad / sec)
	*/
	public float ygyro; 
 	/**
	*Angular speed around Z axis (rad / sec)
	*/
	public float zgyro; 
 	/**
	*X Magnetic field (Gauss)
	*/
	public float xmag; 
 	/**
	*Y Magnetic field (Gauss)
	*/
	public float ymag; 
 	/**
	*Z Magnetic field (Gauss)
	*/
	public float zmag; 
 	/**
	*Absolute pressure in millibar
	*/
	public float abs_pressure; 
 	/**
	*Differential pressure in millibar
	*/
	public float diff_pressure; 
 	/**
	*Altitude calculated from pressure
	*/
	public float pressure_alt; 
 	/**
	*Temperature in degrees celsius
	*/
	public float temperature; 
 	/**
	*Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature
	*/
	public short fields_updated; 

/**
 * Decode a highres_imu message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_usec = payload.getLong();
	    xacc = payload.getFloat();
	    yacc = payload.getFloat();
	    zacc = payload.getFloat();
	    xgyro = payload.getFloat();
	    ygyro = payload.getFloat();
	    zgyro = payload.getFloat();
	    xmag = payload.getFloat();
	    ymag = payload.getFloat();
	    zmag = payload.getFloat();
	    abs_pressure = payload.getFloat();
	    diff_pressure = payload.getFloat();
	    pressure_alt = payload.getFloat();
	    temperature = payload.getFloat();
	    fields_updated = payload.getShort();    
    }

    public msg_highres_imu(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_HIGHRES_IMU;
        unpack(payload);
        Log.d("MAVLink", "HIGHRES_IMU");
    }
}

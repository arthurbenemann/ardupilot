// MESSAGE HIGHRES_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.time_usec = payload.getlong();
	//m.xacc = payload.getfloat();
	//m.yacc = payload.getfloat();
	//m.zacc = payload.getfloat();
	//m.xgyro = payload.getfloat();
	//m.ygyro = payload.getfloat();
	//m.zgyro = payload.getfloat();
	//m.xmag = payload.getfloat();
	//m.ymag = payload.getfloat();
	//m.zmag = payload.getfloat();
	//m.abs_pressure = payload.getfloat();
	//m.diff_pressure = payload.getfloat();
	//m.pressure_alt = payload.getfloat();
	//m.temperature = payload.getfloat();
	//m.fields_updated = payload.getshort();
    
    }
}

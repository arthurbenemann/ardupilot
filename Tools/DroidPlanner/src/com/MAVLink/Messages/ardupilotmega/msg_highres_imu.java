// MESSAGE HIGHRES_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_highres_imu m = new msg_highres_imu();
	//m.time_usec = _get_time_usec(msg);
	//m.xacc = _get_xacc(msg);
	//m.yacc = _get_yacc(msg);
	//m.zacc = _get_zacc(msg);
	//m.xgyro = _get_xgyro(msg);
	//m.ygyro = _get_ygyro(msg);
	//m.zgyro = _get_zgyro(msg);
	//m.xmag = _get_xmag(msg);
	//m.ymag = _get_ymag(msg);
	//m.zmag = _get_zmag(msg);
	//m.abs_pressure = _get_abs_pressure(msg);
	//m.diff_pressure = _get_diff_pressure(msg);
	//m.pressure_alt = _get_pressure_alt(msg);
	//m.temperature = _get_temperature(msg);
	//m.fields_updated = _get_fields_updated(msg);
    return m;	

    }
}

// MESSAGE SCALED_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_scaled_imu m = new msg_scaled_imu();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.xacc = _get_xacc(msg);
	//m.yacc = _get_yacc(msg);
	//m.zacc = _get_zacc(msg);
	//m.xgyro = _get_xgyro(msg);
	//m.ygyro = _get_ygyro(msg);
	//m.zgyro = _get_zgyro(msg);
	//m.xmag = _get_xmag(msg);
	//m.ymag = _get_ymag(msg);
	//m.zmag = _get_zmag(msg);
    return m;	

    }
}

// MESSAGE RAW_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* The RAW IMU readings for the usual 9DOF sensor setup. This message should always contain the true raw values without any scaling to allow data capture and system debugging.
*/
public class msg_raw_imu extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RAW_IMU = 27;
	public static final int MAVLINK_MSG_LENGTH = 26;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*X acceleration (raw)
	*/
	public short xacc; 
 	/**
	*Y acceleration (raw)
	*/
	public short yacc; 
 	/**
	*Z acceleration (raw)
	*/
	public short zacc; 
 	/**
	*Angular speed around X axis (raw)
	*/
	public short xgyro; 
 	/**
	*Angular speed around Y axis (raw)
	*/
	public short ygyro; 
 	/**
	*Angular speed around Z axis (raw)
	*/
	public short zgyro; 
 	/**
	*X Magnetic field (raw)
	*/
	public short xmag; 
 	/**
	*Y Magnetic field (raw)
	*/
	public short ymag; 
 	/**
	*Z Magnetic field (raw)
	*/
	public short zmag; 


/**
 * Decode a raw_imu message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_raw_imu m = new msg_raw_imu();
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
    return m;	

    }
}

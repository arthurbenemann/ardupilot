// MESSAGE RAW_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.time_usec = payload.getlong();
	//m.xacc = payload.getshort();
	//m.yacc = payload.getshort();
	//m.zacc = payload.getshort();
	//m.xgyro = payload.getshort();
	//m.ygyro = payload.getshort();
	//m.zgyro = payload.getshort();
	//m.xmag = payload.getshort();
	//m.ymag = payload.getshort();
	//m.zmag = payload.getshort();
    
    }
}

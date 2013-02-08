// MESSAGE SCALED_IMU PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.time_boot_ms = payload.getint();
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

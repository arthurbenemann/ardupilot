// MESSAGE SCALED_PRESSURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* The pressure readings for the typical setup of one absolute and differential pressure sensor. The units are as specified in each field.
*/
public class msg_scaled_pressure extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SCALED_PRESSURE = 29;
	public static final int MAVLINK_MSG_LENGTH = 14;

 	/**
	*Timestamp (milliseconds since system boot)
	*/
	public int time_boot_ms; 
 	/**
	*Absolute pressure (hectopascal)
	*/
	public float press_abs; 
 	/**
	*Differential pressure 1 (hectopascal)
	*/
	public float press_diff; 
 	/**
	*Temperature measurement (0.01 degrees celsius)
	*/
	public short temperature; 

/**
 * Decode a scaled_pressure message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack() {
	//m.time_boot_ms = payload.getint();
	//m.press_abs = payload.getfloat();
	//m.press_diff = payload.getfloat();
	//m.temperature = payload.getshort();
    
    }
}

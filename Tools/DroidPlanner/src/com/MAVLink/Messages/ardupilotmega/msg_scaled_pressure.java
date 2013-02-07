// MESSAGE SCALED_PRESSURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_scaled_pressure m = new msg_scaled_pressure();
	//m.time_boot_ms = _get_time_boot_ms(msg);
	//m.press_abs = _get_press_abs(msg);
	//m.press_diff = _get_press_diff(msg);
	//m.temperature = _get_temperature(msg);
    return m;	

    }
}

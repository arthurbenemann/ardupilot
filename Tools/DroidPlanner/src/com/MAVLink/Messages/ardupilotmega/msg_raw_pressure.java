// MESSAGE RAW_PRESSURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
* The RAW pressure readings for the typical setup of one absolute pressure and one differential pressure sensor. The sensor values should be the raw, UNSCALED ADC values.
*/
public class msg_raw_pressure extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_RAW_PRESSURE = 28;
	public static final int MAVLINK_MSG_LENGTH = 16;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*Absolute pressure (raw)
	*/
	public short press_abs; 
 	/**
	*Differential pressure 1 (raw)
	*/
	public short press_diff1; 
 	/**
	*Differential pressure 2 (raw)
	*/
	public short press_diff2; 
 	/**
	*Raw Temperature measurement (raw)
	*/
	public short temperature; 

/**
 * Decode a raw_pressure message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(MAVLinkPayload payload) {
    msg_raw_pressure m = new msg_raw_pressure();
	//m.time_usec = _get_time_usec(msg);
	//m.press_abs = _get_press_abs(msg);
	//m.press_diff1 = _get_press_diff1(msg);
	//m.press_diff2 = _get_press_diff2(msg);
	//m.temperature = _get_temperature(msg);
    return m;	

    }
}

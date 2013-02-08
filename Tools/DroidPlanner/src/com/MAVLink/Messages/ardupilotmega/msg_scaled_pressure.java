// MESSAGE SCALED_PRESSURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_boot_ms = payload.getInt();
	    press_abs = payload.getFloat();
	    press_diff = payload.getFloat();
	    temperature = payload.getShort();    
    }

    public msg_scaled_pressure(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SCALED_PRESSURE;
        unpack(payload);
        Log.d("MAVLink", "SCALED_PRESSURE");
    }
}

// MESSAGE RAW_PRESSURE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

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
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_usec = payload.getLong();
	    press_abs = payload.getShort();
	    press_diff1 = payload.getShort();
	    press_diff2 = payload.getShort();
	    temperature = payload.getShort();    
    }

    public msg_raw_pressure(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_RAW_PRESSURE;
        unpack(payload);
        Log.d("MAVLink", "RAW_PRESSURE");
        //Log.d("MAVLINK_MSG_ID_RAW_PRESSURE", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_RAW_PRESSURE -"+" time_usec:"+time_usec+" press_abs:"+press_abs+" press_diff1:"+press_diff1+" press_diff2:"+press_diff2+" temperature:"+temperature+"";
    }
}

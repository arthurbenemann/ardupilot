// MESSAGE SENSOR_OFFSETS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Offsets and calibrations values for hardware
        sensors. This makes it easier to debug the calibration process.
*/
public class msg_sensor_offsets extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SENSOR_OFFSETS = 150;
	public static final int MAVLINK_MSG_LENGTH = 42;

 	/**
	*magnetic declination (radians)
	*/
	public float mag_declination; 
 	/**
	*raw pressure from barometer
	*/
	public int raw_press; 
 	/**
	*raw temperature from barometer
	*/
	public int raw_temp; 
 	/**
	*gyro X calibration
	*/
	public float gyro_cal_x; 
 	/**
	*gyro Y calibration
	*/
	public float gyro_cal_y; 
 	/**
	*gyro Z calibration
	*/
	public float gyro_cal_z; 
 	/**
	*accel X calibration
	*/
	public float accel_cal_x; 
 	/**
	*accel Y calibration
	*/
	public float accel_cal_y; 
 	/**
	*accel Z calibration
	*/
	public float accel_cal_z; 
 	/**
	*magnetometer X offset
	*/
	public short mag_ofs_x; 
 	/**
	*magnetometer Y offset
	*/
	public short mag_ofs_y; 
 	/**
	*magnetometer Z offset
	*/
	public short mag_ofs_z; 

/**
 * Decode a sensor_offsets message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    mag_declination = payload.getFloat();
	    raw_press = payload.getInt();
	    raw_temp = payload.getInt();
	    gyro_cal_x = payload.getFloat();
	    gyro_cal_y = payload.getFloat();
	    gyro_cal_z = payload.getFloat();
	    accel_cal_x = payload.getFloat();
	    accel_cal_y = payload.getFloat();
	    accel_cal_z = payload.getFloat();
	    mag_ofs_x = payload.getShort();
	    mag_ofs_y = payload.getShort();
	    mag_ofs_z = payload.getShort();    
    }

    public msg_sensor_offsets(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SENSOR_OFFSETS;
        unpack(payload);
        Log.d("MAVLink", "SENSOR_OFFSETS");
    }
}

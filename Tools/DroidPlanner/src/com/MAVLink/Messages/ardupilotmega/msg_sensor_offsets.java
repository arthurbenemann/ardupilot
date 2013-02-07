// MESSAGE SENSOR_OFFSETS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_sensor_offsets m = new msg_sensor_offsets();
	//m.mag_declination = _get_mag_declination(msg);
	//m.raw_press = _get_raw_press(msg);
	//m.raw_temp = _get_raw_temp(msg);
	//m.gyro_cal_x = _get_gyro_cal_x(msg);
	//m.gyro_cal_y = _get_gyro_cal_y(msg);
	//m.gyro_cal_z = _get_gyro_cal_z(msg);
	//m.accel_cal_x = _get_accel_cal_x(msg);
	//m.accel_cal_y = _get_accel_cal_y(msg);
	//m.accel_cal_z = _get_accel_cal_z(msg);
	//m.mag_ofs_x = _get_mag_ofs_x(msg);
	//m.mag_ofs_y = _get_mag_ofs_y(msg);
	//m.mag_ofs_z = _get_mag_ofs_z(msg);
    return m;	

    }
}

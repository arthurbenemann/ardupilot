// MESSAGE BATTERY_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Transmitte battery informations for a accu pack.
*/
public class msg_battery_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_BATTERY_STATUS = 147;
	public static final int MAVLINK_MSG_LENGTH = 16;

 	/**
	*Battery voltage of cell 1, in millivolts (1 = 1 millivolt)
	*/
	public short voltage_cell_1; 
 	/**
	*Battery voltage of cell 2, in millivolts (1 = 1 millivolt), -1: no cell
	*/
	public short voltage_cell_2; 
 	/**
	*Battery voltage of cell 3, in millivolts (1 = 1 millivolt), -1: no cell
	*/
	public short voltage_cell_3; 
 	/**
	*Battery voltage of cell 4, in millivolts (1 = 1 millivolt), -1: no cell
	*/
	public short voltage_cell_4; 
 	/**
	*Battery voltage of cell 5, in millivolts (1 = 1 millivolt), -1: no cell
	*/
	public short voltage_cell_5; 
 	/**
	*Battery voltage of cell 6, in millivolts (1 = 1 millivolt), -1: no cell
	*/
	public short voltage_cell_6; 
 	/**
	*Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the current
	*/
	public short current_battery; 
 	/**
	*Accupack ID
	*/
	public byte accu_id; 
 	/**
	*Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining battery
	*/
	public byte battery_remaining; 


/**
 * Decode a battery_status message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_battery_status m = new msg_battery_status();
	//m.voltage_cell_1 = _get_voltage_cell_1(msg);
	//m.voltage_cell_2 = _get_voltage_cell_2(msg);
	//m.voltage_cell_3 = _get_voltage_cell_3(msg);
	//m.voltage_cell_4 = _get_voltage_cell_4(msg);
	//m.voltage_cell_5 = _get_voltage_cell_5(msg);
	//m.voltage_cell_6 = _get_voltage_cell_6(msg);
	//m.current_battery = _get_current_battery(msg);
	//m.accu_id = _get_accu_id(msg);
	//m.battery_remaining = _get_battery_remaining(msg);
    return m;	

    }
}

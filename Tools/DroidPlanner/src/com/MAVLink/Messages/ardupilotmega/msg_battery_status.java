// MESSAGE BATTERY_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

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
public void unpack() {
	//m.voltage_cell_1 = payload.getshort();
	//m.voltage_cell_2 = payload.getshort();
	//m.voltage_cell_3 = payload.getshort();
	//m.voltage_cell_4 = payload.getshort();
	//m.voltage_cell_5 = payload.getshort();
	//m.voltage_cell_6 = payload.getshort();
	//m.current_battery = payload.getshort();
	//m.accu_id = payload.getbyte();
	//m.battery_remaining = payload.getbyte();
    
    }
}

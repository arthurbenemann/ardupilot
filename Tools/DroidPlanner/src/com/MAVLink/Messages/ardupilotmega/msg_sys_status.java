// MESSAGE SYS_STATUS PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* The general system state. If the system is following the MAVLink standard, the system state is mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with autonomous position control, position setpoint controlled manually) or AUTO (system guided by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation state machine. The system status shows wether the system is currently active or not and if an emergency occured. During the CRITICAL and EMERGENCY states the MAV is still considered to be active, but should start emergency procedures autonomously. After a failure occured it should first move from active to critical to allow manual intervention and then move to emergency after a certain timeout.
*/
public class msg_sys_status extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_SYS_STATUS = 1;
	public static final int MAVLINK_MSG_LENGTH = 31;

 	/**
	*Bitmask showing which onboard controllers and sensors are present. Value of 0: not present. Value of 1: present. Indices: 0: 3D gyro, 1: 3D acc, 2: 3D mag, 3: absolute pressure, 4: differential pressure, 5: GPS, 6: optical flow, 7: computer vision position, 8: laser based position, 9: external ground-truth (Vicon or Leica). Controllers: 10: 3D angular rate control 11: attitude stabilization, 12: yaw position, 13: z/altitude control, 14: x/y position control, 15: motor outputs / control
	*/
	public int onboard_control_sensors_present; 
 	/**
	*Bitmask showing which onboard controllers and sensors are enabled:  Value of 0: not enabled. Value of 1: enabled. Indices: 0: 3D gyro, 1: 3D acc, 2: 3D mag, 3: absolute pressure, 4: differential pressure, 5: GPS, 6: optical flow, 7: computer vision position, 8: laser based position, 9: external ground-truth (Vicon or Leica). Controllers: 10: 3D angular rate control 11: attitude stabilization, 12: yaw position, 13: z/altitude control, 14: x/y position control, 15: motor outputs / control
	*/
	public int onboard_control_sensors_enabled; 
 	/**
	*Bitmask showing which onboard controllers and sensors are operational or have an error:  Value of 0: not enabled. Value of 1: enabled. Indices: 0: 3D gyro, 1: 3D acc, 2: 3D mag, 3: absolute pressure, 4: differential pressure, 5: GPS, 6: optical flow, 7: computer vision position, 8: laser based position, 9: external ground-truth (Vicon or Leica). Controllers: 10: 3D angular rate control 11: attitude stabilization, 12: yaw position, 13: z/altitude control, 14: x/y position control, 15: motor outputs / control
	*/
	public int onboard_control_sensors_health; 
 	/**
	*Maximum usage in percent of the mainloop time, (0%: 0, 100%: 1000) should be always below 1000
	*/
	public short load; 
 	/**
	*Battery voltage, in millivolts (1 = 1 millivolt)
	*/
	public short voltage_battery; 
 	/**
	*Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the current
	*/
	public short current_battery; 
 	/**
	*Communication drops in percent, (0%: 0, 100%: 10'000), (UART, I2C, SPI, CAN), dropped packets on all links (packets that were corrupted on reception on the MAV)
	*/
	public short drop_rate_comm; 
 	/**
	*Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were corrupted on reception on the MAV)
	*/
	public short errors_comm; 
 	/**
	*Autopilot-specific errors
	*/
	public short errors_count1; 
 	/**
	*Autopilot-specific errors
	*/
	public short errors_count2; 
 	/**
	*Autopilot-specific errors
	*/
	public short errors_count3; 
 	/**
	*Autopilot-specific errors
	*/
	public short errors_count4; 
 	/**
	*Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot estimate the remaining battery
	*/
	public byte battery_remaining; 

/**
 * Decode a sys_status message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    onboard_control_sensors_present = payload.getInt();
	    onboard_control_sensors_enabled = payload.getInt();
	    onboard_control_sensors_health = payload.getInt();
	    load = payload.getShort();
	    voltage_battery = payload.getShort();
	    current_battery = payload.getShort();
	    drop_rate_comm = payload.getShort();
	    errors_comm = payload.getShort();
	    errors_count1 = payload.getShort();
	    errors_count2 = payload.getShort();
	    errors_count3 = payload.getShort();
	    errors_count4 = payload.getShort();
	    battery_remaining = payload.getByte();    
    }

    public msg_sys_status(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_SYS_STATUS;
        unpack(payload);
        Log.d("MAVLink", "SYS_STATUS");
    }
}

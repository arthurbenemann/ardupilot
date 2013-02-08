// MESSAGE MANUAL_CONTROL PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* This message provides an API for manually controlling the vehicle using standard joystick axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an buttons are also transmit as boolean values of their 
*/
public class msg_manual_control extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MANUAL_CONTROL = 69;
	public static final int MAVLINK_MSG_LENGTH = 11;

 	/**
	*X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and the pitch of a vehicle.
	*/
	public short x; 
 	/**
	*Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the roll of a vehicle.
	*/
	public short y; 
 	/**
	*Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a separate slider movement with maximum being 1000 and minimum being -1000 on a joystick and the thrust of a vehicle.
	*/
	public short z; 
 	/**
	*R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 1000 and clockwise being -1000, and the yaw of a vehicle.
	*/
	public short r; 
 	/**
	*A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for released. The lowest bit corresponds to Button 1.
	*/
	public short buttons; 
 	/**
	*The system to be controlled.
	*/
	public byte target; 

/**
 * Decode a manual_control message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.x = payload.getshort();
	//m.y = payload.getshort();
	//m.z = payload.getshort();
	//m.r = payload.getshort();
	//m.buttons = payload.getshort();
	//m.target = payload.getbyte();
    
    }

    public msg_manual_control(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "MANUAL_CONTROL");
	}
}

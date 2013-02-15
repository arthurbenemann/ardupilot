// MESSAGE MANUAL_SETPOINT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Setpoint in roll, pitch, yaw and thrust from the operator
*/
public class msg_manual_setpoint extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MANUAL_SETPOINT = 81;
	public static final int MAVLINK_MSG_LENGTH = 22;
	private static final long serialVersionUID = MAVLINK_MSG_ID_MANUAL_SETPOINT;
	

 	/**
	*Timestamp in milliseconds since system boot
	*/
	public int time_boot_ms; 
 	/**
	*Desired roll rate in radians per second
	*/
	public float roll; 
 	/**
	*Desired pitch rate in radians per second
	*/
	public float pitch; 
 	/**
	*Desired yaw rate in radians per second
	*/
	public float yaw; 
 	/**
	*Collective thrust, normalized to 0 .. 1
	*/
	public float thrust; 
 	/**
	*Flight mode switch position, 0.. 255
	*/
	public byte mode_switch; 
 	/**
	*Override mode switch position, 0.. 255
	*/
	public byte manual_override_switch; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.len = MAVLINK_MSG_LENGTH;
		packet.sysid = 255;
		packet.compid = 190;
		packet.msgid = MAVLINK_MSG_ID_MANUAL_SETPOINT;
		packet.payload.putInt(time_boot_ms);
		packet.payload.putFloat(roll);
		packet.payload.putFloat(pitch);
		packet.payload.putFloat(yaw);
		packet.payload.putFloat(thrust);
		packet.payload.putByte(mode_switch);
		packet.payload.putByte(manual_override_switch);
		return packet;		
	}

    /**
     * Decode a manual_setpoint message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_boot_ms = payload.getInt();
	    roll = payload.getFloat();
	    pitch = payload.getFloat();
	    yaw = payload.getFloat();
	    thrust = payload.getFloat();
	    mode_switch = payload.getByte();
	    manual_override_switch = payload.getByte();    
    }

     /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_manual_setpoint(){
    	msgid = MAVLINK_MSG_ID_MANUAL_SETPOINT;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_manual_setpoint(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_MANUAL_SETPOINT;
        unpack(payload);
        Log.d("MAVLink", "MANUAL_SETPOINT");
        //Log.d("MAVLINK_MSG_ID_MANUAL_SETPOINT", toString());
    }
    
              
    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_MANUAL_SETPOINT -"+" time_boot_ms:"+time_boot_ms+" roll:"+roll+" pitch:"+pitch+" yaw:"+yaw+" thrust:"+thrust+" mode_switch:"+mode_switch+" manual_override_switch:"+manual_override_switch+"";
    }
}

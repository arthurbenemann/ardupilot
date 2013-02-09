// MESSAGE CHANGE_OPERATOR_CONTROL_ACK PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* Accept / deny control of this MAV
*/
public class msg_change_operator_control_ack extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK = 6;
	public static final int MAVLINK_MSG_LENGTH = 3;

 	/**
	*ID of the GCS this message 
	*/
	public byte gcs_system_id; 
 	/**
	*0: request control of this MAV, 1: Release control of this MAV
	*/
	public byte control_request; 
 	/**
	*0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: Already under control
	*/
	public byte ack; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;
		packet.payload.putByte(gcs_system_id);
		packet.payload.putByte(control_request);
		packet.payload.putByte(ack);
		return packet;		
	}

    /**
     * Decode a change_operator_control_ack message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    gcs_system_id = payload.getByte();
	    control_request = payload.getByte();
	    ack = payload.getByte();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_change_operator_control_ack(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK;
        unpack(payload);
        Log.d("MAVLink", "CHANGE_OPERATOR_CONTROL_ACK");
        //Log.d("MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK -"+" gcs_system_id:"+gcs_system_id+" control_request:"+control_request+" ack:"+ack+"";
    }
}

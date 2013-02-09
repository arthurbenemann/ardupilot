// MESSAGE GLOBAL_VISION_POSITION_ESTIMATE PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* 
*/
public class msg_global_vision_position_estimate extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE = 101;
	public static final int MAVLINK_MSG_LENGTH = 32;

 	/**
	*Timestamp (microseconds, synced to UNIX time or since system boot)
	*/
	public long usec; 
 	/**
	*Global X position
	*/
	public float x; 
 	/**
	*Global Y position
	*/
	public float y; 
 	/**
	*Global Z position
	*/
	public float z; 
 	/**
	*Roll angle in rad
	*/
	public float roll; 
 	/**
	*Pitch angle in rad
	*/
	public float pitch; 
 	/**
	*Yaw angle in rad
	*/
	public float yaw; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE;
		packet.payload.putLong(usec);
		packet.payload.putFloat(x);
		packet.payload.putFloat(y);
		packet.payload.putFloat(z);
		packet.payload.putFloat(roll);
		packet.payload.putFloat(pitch);
		packet.payload.putFloat(yaw);
		return packet;		
	}

    /**
     * Decode a global_vision_position_estimate message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    usec = payload.getLong();
	    x = payload.getFloat();
	    y = payload.getFloat();
	    z = payload.getFloat();
	    roll = payload.getFloat();
	    pitch = payload.getFloat();
	    yaw = payload.getFloat();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_global_vision_position_estimate(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE;
        unpack(payload);
        Log.d("MAVLink", "GLOBAL_VISION_POSITION_ESTIMATE");
        //Log.d("MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE -"+" usec:"+usec+" x:"+x+" y:"+y+" z:"+z+" roll:"+roll+" pitch:"+pitch+" yaw:"+yaw+"";
    }
}

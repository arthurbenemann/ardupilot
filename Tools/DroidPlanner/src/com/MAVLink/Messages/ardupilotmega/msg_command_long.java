// MESSAGE COMMAND_LONG PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Send a command with up to four parameters to the MAV
*/
public class msg_command_long extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_COMMAND_LONG = 76;
	public static final int MAVLINK_MSG_LENGTH = 33;

 	/**
	*Parameter 1, as defined by MAV_CMD enum.
	*/
	public float param1; 
 	/**
	*Parameter 2, as defined by MAV_CMD enum.
	*/
	public float param2; 
 	/**
	*Parameter 3, as defined by MAV_CMD enum.
	*/
	public float param3; 
 	/**
	*Parameter 4, as defined by MAV_CMD enum.
	*/
	public float param4; 
 	/**
	*Parameter 5, as defined by MAV_CMD enum.
	*/
	public float param5; 
 	/**
	*Parameter 6, as defined by MAV_CMD enum.
	*/
	public float param6; 
 	/**
	*Parameter 7, as defined by MAV_CMD enum.
	*/
	public float param7; 
 	/**
	*Command ID, as defined by MAV_CMD enum.
	*/
	public short command; 
 	/**
	*System which should execute the command
	*/
	public byte target_system; 
 	/**
	*Component which should execute the command, 0 for all components
	*/
	public byte target_component; 
 	/**
	*0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill command)
	*/
	public byte confirmation; 

/**
 * Decode a command_long message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    param1 = payload.getFloat();
	    param2 = payload.getFloat();
	    param3 = payload.getFloat();
	    param4 = payload.getFloat();
	    param5 = payload.getFloat();
	    param6 = payload.getFloat();
	    param7 = payload.getFloat();
	    command = payload.getShort();
	    target_system = payload.getByte();
	    target_component = payload.getByte();
	    confirmation = payload.getByte();    
    }

    public msg_command_long(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_COMMAND_LONG;
        unpack(payload);
        Log.d("MAVLink", "COMMAND_LONG");
        //Log.d("MAVLINK_MSG_ID_COMMAND_LONG", toString());
    }

    public String toString(){
    	return "MAVLINK_MSG_ID_COMMAND_LONG -"+" param1:"+param1+" param2:"+param2+" param3:"+param3+" param4:"+param4+" param5:"+param5+" param6:"+param6+" param7:"+param7+" command:"+command+" target_system:"+target_system+" target_component:"+target_component+" confirmation:"+confirmation+"";
    }
}

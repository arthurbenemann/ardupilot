// MESSAGE MISSION_ITEM PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* Message encoding a mission item. This message is emitted to announce
                the presence of a mission item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). See also http://qgroundcontrol.org/mavlink/waypoint_protocol.
*/
public class msg_mission_item extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_MISSION_ITEM = 39;
	public static final int MAVLINK_MSG_LENGTH = 37;

 	/**
	*PARAM1 / For NAV command MISSIONs: Radius in which the MISSION is accepted as reached, in meters
	*/
	public float param1; 
 	/**
	*PARAM2 / For NAV command MISSIONs: Time that the MAV should stay inside the PARAM1 radius before advancing, in milliseconds
	*/
	public float param2; 
 	/**
	*PARAM3 / For LOITER command MISSIONs: Orbit to circle around the MISSION, in meters. If positive the orbit direction should be clockwise, if negative the orbit direction should be counter-clockwise.
	*/
	public float param3; 
 	/**
	*PARAM4 / For NAV and LOITER command MISSIONs: Yaw orientation in degrees, [0..360] 0 = NORTH
	*/
	public float param4; 
 	/**
	*PARAM5 / local: x position, global: latitude
	*/
	public float x; 
 	/**
	*PARAM6 / y position: global: longitude
	*/
	public float y; 
 	/**
	*PARAM7 / z position: global: altitude
	*/
	public float z; 
 	/**
	*Sequence
	*/
	public short seq; 
 	/**
	*The scheduled action for the MISSION. see MAV_CMD in common.xml MAVLink specs
	*/
	public short command; 
 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 
 	/**
	*The coordinate system of the MISSION. see MAV_FRAME in mavlink_types.h
	*/
	public byte frame; 
 	/**
	*false:0, true:1
	*/
	public byte current; 
 	/**
	*autocontinue to next wp
	*/
	public byte autocontinue; 

/**
 * Decode a mission_item message into this class fields
 *
 * @param payload The message to decode
 */
public void unpack(MAVLinkPayload payload) {
	//m.param1 = payload.getfloat();
	//m.param2 = payload.getfloat();
	//m.param3 = payload.getfloat();
	//m.param4 = payload.getfloat();
	//m.x = payload.getfloat();
	//m.y = payload.getfloat();
	//m.z = payload.getfloat();
	//m.seq = payload.getshort();
	//m.command = payload.getshort();
	//m.target_system = payload.getbyte();
	//m.target_component = payload.getbyte();
	//m.frame = payload.getbyte();
	//m.current = payload.getbyte();
	//m.autocontinue = payload.getbyte();
    
    }

    public msg_mission_item(MAVLinkPayload payload){
	unpack(payload);
	Log.d("MAVLink", "MISSION_ITEM");
	}
}

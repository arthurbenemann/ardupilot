package com.MAVLink.Messages.common;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_heartbeat extends MAVLinkMessage{

	public msg_heartbeat(){ messageType = MAVLINK_MSG_ID_HEARTBEAT; }

	public static final int MAVLINK_MSG_ID_HEARTBEAT = 0;

	private static final long serialVersionUID = MAVLINK_MSG_ID_HEARTBEAT;

	public long custom_mode; ///< Navigation mode bitfield, see MAV_AUTOPILOT_CUSTOM_MODE ENUM for some examples. This field is autopilot-specific.
	public int type; ///< Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in MAV_TYPE ENUM)
	public int autopilot; ///< Autopilot type / class. defined in MAV_CLASS ENUM
	public int base_mode; ///< System mode bitfield, see MAV_MODE_FLAGS ENUM in mavlink/include/mavlink_types.h
	public int system_status; ///< System status flag, see MAV_STATUS ENUM
	public int mavlink_version; ///< MAVLink version

	public static MAVLinkMessage unpackHeartBeat(List<Integer> payload) {
		msg_heartbeat m = new msg_heartbeat();
		m.type = getInt8(0,payload);
		m.autopilot = getInt8(1,payload);
		m.base_mode = getInt8(2,payload);
		m.custom_mode = getInt32(4,payload);
		m.system_status = getInt8(8,payload);
		m.mavlink_version = getInt8(9,payload);
		return m;		
	}
	
}
package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint extends MAVLinkMessage{

	public msg_waypoint(){ messageType = MAVLINK_MSG_ID_WAYPOINT; }

	public static final int MAVLINK_MSG_ID_WAYPOINT = 39;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID
	public int seq; ///< Sequence
	public int frame; ///< The coordinate system of the waypoint. see MAV_FRAME in mavlink_types.h
	public int command; ///< The scheduled action for the waypoint. see MAV_COMMAND in common.xml MAVLink specs
	public int current; ///< false:0, true:1
	public int autocontinue; ///< autocontinue to next wp
	public float param1; ///< PARAM1 / For NAV command waypoints: Radius in which the waypoint is accepted as reached, in meters
	public float param2; ///< PARAM2 / For NAV command waypoints: Time that the MAV should stay inside the PARAM1 radius before advancing, in milliseconds
	public float param3; ///< PARAM3 / For LOITER command waypoints: Orbit to circle around the waypoint, in meters. If positive the orbit direction should be clockwise, if negative the orbit direction should be counter-clockwise.
	public float param4; ///< PARAM4 / For NAV and LOITER command waypoints: Yaw orientation in degrees, [0..360] 0 = NORTH
	public float x; ///< PARAM5 / local: x position, global: latitude
	public float y; ///< PARAM6 / y position: global: longitude
	public float z; ///< PARAM7 / z position: global: altitude

}
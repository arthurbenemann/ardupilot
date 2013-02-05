package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_count extends MAVLinkMessage{

	public msg_waypoint_count(){ messageType = MAVLINK_MSG_ID_WAYPOINT_COUNT; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_COUNT = 44;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_COUNT;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID
	public int count; ///< Number of Waypoints in the Sequence

}
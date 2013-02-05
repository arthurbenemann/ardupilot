package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_set_current extends MAVLinkMessage{

	public msg_waypoint_set_current(){ messageType = MAVLINK_MSG_ID_WAYPOINT_SET_CURRENT; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_SET_CURRENT = 41;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_SET_CURRENT;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID
	public int seq; ///< Sequence

}
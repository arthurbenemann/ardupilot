package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_clear_all extends MAVLinkMessage{

	public msg_waypoint_clear_all(){ messageType = MAVLINK_MSG_ID_WAYPOINT_CLEAR_ALL; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_CLEAR_ALL = 45;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_CLEAR_ALL;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID

}
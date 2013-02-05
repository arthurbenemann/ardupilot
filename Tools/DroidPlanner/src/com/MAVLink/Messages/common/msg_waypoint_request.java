package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_request extends MAVLinkMessage{

	public msg_waypoint_request(){ messageType = MAVLINK_MSG_ID_WAYPOINT_REQUEST; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_REQUEST = 40;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_REQUEST;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID
	public int seq; ///< Sequence

}
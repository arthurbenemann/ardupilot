package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_current extends MAVLinkMessage{

	public msg_waypoint_current(){ messageType = MAVLINK_MSG_ID_WAYPOINT_CURRENT; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_CURRENT = 42;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_CURRENT;

	public int seq; ///< Sequence

}
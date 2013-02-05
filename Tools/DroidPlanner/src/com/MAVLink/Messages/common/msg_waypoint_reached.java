package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_reached extends MAVLinkMessage{

	public msg_waypoint_reached(){ messageType = MAVLINK_MSG_ID_WAYPOINT_REACHED; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_REACHED = 46;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_REACHED;

	public int seq; ///< Sequence

}
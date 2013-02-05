package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_request_list extends MAVLinkMessage{

	public msg_waypoint_request_list(){ messageType = MAVLINK_MSG_ID_WAYPOINT_REQUEST_LIST; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_REQUEST_LIST = 43;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_REQUEST_LIST;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID

}
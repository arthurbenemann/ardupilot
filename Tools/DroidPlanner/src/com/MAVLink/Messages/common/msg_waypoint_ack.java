package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_waypoint_ack extends MAVLinkMessage{

	public msg_waypoint_ack(){ messageType = MAVLINK_MSG_ID_WAYPOINT_ACK; }

	public static final int MAVLINK_MSG_ID_WAYPOINT_ACK = 47;

	private static final long serialVersionUID = MAVLINK_MSG_ID_WAYPOINT_ACK;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID
	public int type; ///< 0: OK, 1: Error

}
package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_set_altitude extends MAVLinkMessage{

	public msg_set_altitude(){ messageType = MAVLINK_MSG_ID_SET_ALTITUDE; }

	public static final int MAVLINK_MSG_ID_SET_ALTITUDE = 65;

	private static final long serialVersionUID = MAVLINK_MSG_ID_SET_ALTITUDE;

	public int target; ///< The system setting the altitude
	public long mode; ///< The new altitude in meters

}
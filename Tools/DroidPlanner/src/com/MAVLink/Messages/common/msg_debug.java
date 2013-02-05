package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_debug extends MAVLinkMessage{

	public msg_debug(){ messageType = MAVLINK_MSG_ID_DEBUG; }

	public static final int MAVLINK_MSG_ID_DEBUG = 254;

	private static final long serialVersionUID = MAVLINK_MSG_ID_DEBUG;

	public long time_boot_ms; ///< Timestamp (milliseconds since system boot)
	public float value; ///< DEBUG value
	public int ind; ///< index of debug variable

}
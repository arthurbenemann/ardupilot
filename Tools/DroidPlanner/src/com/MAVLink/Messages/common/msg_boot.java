package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_boot extends MAVLinkMessage{

	public msg_boot(){ messageType = MAVLINK_MSG_ID_BOOT; }

	public static final int MAVLINK_MSG_ID_BOOT = 1;

	private static final long serialVersionUID = MAVLINK_MSG_ID_BOOT;

	public long version; ///< The onboard software version

}
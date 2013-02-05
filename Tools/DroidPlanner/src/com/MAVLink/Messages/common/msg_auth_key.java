package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_auth_key extends MAVLinkMessage{

	public msg_auth_key(){ messageType = MAVLINK_MSG_ID_AUTH_KEY; }

	public static final int MAVLINK_MSG_ID_AUTH_KEY = 7;

	private static final long serialVersionUID = MAVLINK_MSG_ID_AUTH_KEY;

	public 	char[] key = new char[32];///< key

}
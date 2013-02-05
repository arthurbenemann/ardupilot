package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_named_value_float extends MAVLinkMessage{

	public msg_named_value_float(){ messageType = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT; }

	public static final int MAVLINK_MSG_ID_NAMED_VALUE_FLOAT = 251;

	private static final long serialVersionUID = MAVLINK_MSG_ID_NAMED_VALUE_FLOAT;

	public long time_boot_ms; ///< Timestamp (milliseconds since system boot)
	public float value; ///< Floating point value
	public 	char[] name = new char[10];///< Name of the debug variable

}
package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_command_ack extends MAVLinkMessage{

	public msg_command_ack(){ messageType = MAVLINK_MSG_ID_COMMAND_ACK; }

	public static final int MAVLINK_MSG_ID_COMMAND_ACK = 77;

	private static final long serialVersionUID = MAVLINK_MSG_ID_COMMAND_ACK;

	public int command; ///< Command ID, as defined by MAV_CMD enum.
	public int result; ///< See MAV_RESULT enum

}
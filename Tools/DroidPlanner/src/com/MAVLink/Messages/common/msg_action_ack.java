package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_action_ack extends MAVLinkMessage{

	public msg_action_ack(){ messageType = MAVLINK_MSG_ID_ACTION_ACK; }

	public static final int MAVLINK_MSG_ID_ACTION_ACK = 9;

	private static final long serialVersionUID = MAVLINK_MSG_ID_ACTION_ACK;

	public int action; ///< The action id
	public int result; ///< 0: Action DENIED, 1: Action executed

}
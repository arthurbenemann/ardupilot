package com.MAVLink.Messages.common;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_action extends MAVLinkMessage{

	public msg_action(){ messageType = MAVLINK_MSG_ID_ACTION; }

	public static final int MAVLINK_MSG_ID_ACTION = 10;

	private static final long serialVersionUID = MAVLINK_MSG_ID_ACTION;

	public int target; ///< The system executing the action
	public int target_component; ///< The component executing the action
	public int action; ///< The action id

}
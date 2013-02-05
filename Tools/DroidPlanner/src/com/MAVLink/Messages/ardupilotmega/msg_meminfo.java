package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_meminfo extends MAVLinkMessage{

	public msg_meminfo(){ messageType = MAVLINK_MSG_ID_MEMINFO; }

	public static final int MAVLINK_MSG_ID_MEMINFO = 152;

	private static final long serialVersionUID = MAVLINK_MSG_ID_MEMINFO;

	public int brkval; ///< heap top
	public int freemem; ///< free memory

}
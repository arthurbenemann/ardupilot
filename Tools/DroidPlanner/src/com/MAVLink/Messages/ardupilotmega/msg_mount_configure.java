package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_mount_configure extends MAVLinkMessage{

	public msg_mount_configure(){ messageType = MAVLINK_MSG_ID_MOUNT_CONFIGURE; }

	public static final int MAVLINK_MSG_ID_MOUNT_CONFIGURE = 156;

	private static final long serialVersionUID = MAVLINK_MSG_ID_MOUNT_CONFIGURE;

	public int target_system; ///< System ID
	public int target_component; ///< Component ID
	public int mount_mode; ///< mount operating mode (see MAV_MOUNT_MODE enum)
	public int stab_roll; ///< (1 = yes, 0 = no)
	public int stab_pitch; ///< (1 = yes, 0 = no)
	public int stab_yaw; ///< (1 = yes, 0 = no)

}
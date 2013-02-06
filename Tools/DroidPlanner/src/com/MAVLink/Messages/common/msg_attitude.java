package com.MAVLink.Messages.common;

import java.util.List;

import android.util.Log;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_attitude extends MAVLinkMessage{

	public msg_attitude(){ messageType = MAVLINK_MSG_ID_ATTITUDE; }

	public static final int MAVLINK_MSG_ID_ATTITUDE = 30;

	private static final long serialVersionUID = MAVLINK_MSG_ID_ATTITUDE;

	public long time_boot_ms; ///< Timestamp (milliseconds since system boot)
	public float roll; ///< Roll angle (rad)
	public float pitch; ///< Pitch angle (rad)
	public float yaw; ///< Yaw angle (rad)
	public float rollspeed; ///< Roll angular speed (rad/s)
	public float pitchspeed; ///< Pitch angular speed (rad/s)
	public float yawspeed; ///< Yaw angular speed (rad/s)


	public static MAVLinkMessage unpack(List<Integer> payload) {
		msg_attitude m = new msg_attitude();
		m.time_boot_ms = getInt32(0,payload);
		Log.d("MAVLink", "time_boot - "+m.time_boot_ms);
		m.roll = getFloat(4,payload);
		Log.d("ROLL", "roll - "+m.roll);
		m.pitch = getFloat(8,payload);
		m.yaw = getFloat(12,payload);
		m.rollspeed = getFloat(16,payload);
		m.pitchspeed = getFloat(20,payload);
		m.yawspeed = getFloat(24,payload);
		return m;
	}
}
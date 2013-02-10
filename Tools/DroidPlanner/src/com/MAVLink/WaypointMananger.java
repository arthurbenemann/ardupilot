package com.MAVLink;

import android.util.Log;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_mission_ack;
import com.MAVLink.Messages.ardupilotmega.msg_mission_count;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_list;

public class WaypointMananger {
	MAVLink MAV;
	
	public WaypointMananger(MAVLink MAV){
		this.MAV = MAV;
	}
	
	/**
	 * Try to process a Mavlink message if it is a mission related message
	 * @param msg Mavlink message to process
	 * @return Returns true if the message has been processed
	 */
	public boolean processMessage(MAVLinkMessage msg){
		switch (msg.msgid) {
		case msg_mission_count.MAVLINK_MSG_ID_MISSION_COUNT:
			Log.d("Mission", "Count");
			requestWayPoint();
			return true;
		case msg_mission_item.MAVLINK_MSG_ID_MISSION_ITEM:
			Log.d("Mission", "Item");
			return true;
		case msg_mission_ack.MAVLINK_MSG_ID_MISSION_ACK:
			Log.d("Mission", "Ack");
			return true;
		default:
			return false;
		}
		
	}

	public void requestWaypointsList(){
		Log.d("Mission", "requestList");
		msg_mission_request_list msg = new msg_mission_request_list();
		msg.target_system = 1;
		msg.target_component = 1;
	    MAV.sendMavPacket(msg.pack());
	}
	
	private void requestWayPoint() {
		Log.d("Mission", "requestPoint");
		msg_mission_request msg = new msg_mission_request();
		msg.target_system = 1;
		msg.target_component = 1;
		msg.seq = 0;
	    MAV.sendMavPacket(msg.pack());	
		
	}
}

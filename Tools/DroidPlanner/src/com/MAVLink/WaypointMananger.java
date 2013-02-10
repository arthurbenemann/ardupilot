package com.MAVLink;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_mission_ack;
import com.MAVLink.Messages.ardupilotmega.msg_mission_count;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_list;
import com.diydrones.droidplanner.waypoint;

public abstract class WaypointMananger {
	MAVLink MAV;
	private short waypointCount;

	private List<waypoint> waypoints;
	

	public abstract void onWaypointsReceived(List<waypoint> waypoints);
	
	public void getWaypoints(){
		requestWaypointsList();
	}
	
	public WaypointMananger(MAVLink MAV){
		this.MAV = MAV;
		waypoints = new ArrayList<waypoint>();
	}
	
	/**
	 * Try to process a Mavlink message if it is a mission related message
	 * @param msg Mavlink message to process
	 * @return Returns true if the message has been processed
	 */
	public boolean processMessage(MAVLinkMessage msg){
		switch (msg.msgid) {
		case msg_mission_count.MAVLINK_MSG_ID_MISSION_COUNT:
			waypointCount = ((msg_mission_count) msg).count;
			Log.d("Mission", "Count:"+waypointCount);
			waypoints.clear();
			requestWayPoint();
			return true;
		case msg_mission_item.MAVLINK_MSG_ID_MISSION_ITEM:
			Double Lat = (double) ((msg_mission_item) msg).x;
			Double Lng = (double) ((msg_mission_item) msg).y;
			Double h = (double) ((msg_mission_item) msg).z;
			waypoints.add(new waypoint(Lat, Lng, h));
			Log.d("Mission", "Item:"+waypoints.size()+" Lng:"+Lng+" Lat:"+Lat+" h:"+h);
			
			if(waypoints.size()<waypointCount){
				requestWayPoint();
			}else{
				sendAck();
				onWaypointsReceived(waypoints);
			}
			return true;
		default:
			return false;
		}
		
	}

	private void sendAck() {
		Log.d("Mission", "Ack");
		msg_mission_ack msg = new msg_mission_ack();
		msg.target_system = 1;
		msg.target_component = 1;
		msg.type = 0; //TODO use MAV_MISSION_RESULT constant
	    MAV.sendMavPacket(msg.pack());	
		
	}

	private void requestWaypointsList(){
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
		msg.seq = (short) waypoints.size();
	    MAV.sendMavPacket(msg.pack());			
	}
}

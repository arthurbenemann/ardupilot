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

/**
 * Class to manage the communication of waypoints to the MAV. 
 * 
 * Should be initialized with a MAVLink Object, so the manager can send messages via the
 * MAV link. The function processMessage must be called with every new MAV Message.
 * 
 */
public abstract class WaypointMananger {
	/**
	 * Try to receive all waypoints from the MAV. 
	 * 
	 * If all runs well the callback will return the list of waypoints. 
	 */
	public void getWaypoints(){
		if(MAV.isConnected()){
			requestWaypointsList();
		}
	}
	
	/**
	 * Write a list of waypoints to the MAV.
	 * 
	 * The callback will return the status of this operation
	 * @param data waypoints to be written
	 */
	public void writeWaypoints(List<waypoint> data){
		if((waypoints!=null) && (MAV.isConnected())){
			waypoints = data;
			writeIndex = 0;
			sendWaypointCount();
		}
	}
	

	/**
	 * Callback for when all waypoints have been received.
	 * @param waypoints list with received waypoints.
	 */
	public abstract void onWaypointsReceived(List<waypoint> waypoints);
	
	/**
	 * Callback for when all waypoints have been written.
	 * @param msg Acknowledgment message from the MAV
	 */
	public abstract void onWriteWaypoints(msg_mission_ack msg);
	
	/**
	 * Object with a MAVlink connection
	 */
	MAVLink MAV;
	/**
	 * number of waypoints to be received, used when reading waypoints
	 */
	private short waypointCount;
	/**
	 * list of waypoints used when writing or receiving
	 */
	private List<waypoint> waypoints;
	/**
	 * waypoint witch is currently being written
	 */
	private int writeIndex;
	
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
			requestFirstWaypoint(msg);
			return true;
		case msg_mission_item.MAVLINK_MSG_ID_MISSION_ITEM:
			processReceivedWaypoint((msg_mission_item) msg);
			return true;			
		case msg_mission_request.MAVLINK_MSG_ID_MISSION_REQUEST:
			sendWaypoint(waypoints.get(writeIndex++));
			return true;
		case msg_mission_ack.MAVLINK_MSG_ID_MISSION_ACK:
			onWriteWaypoints((msg_mission_ack)msg);
		default:
			return false;
		}		
	}

	private void requestFirstWaypoint(MAVLinkMessage msg) {
		waypointCount = ((msg_mission_count) msg).count;
		Log.d("Mission", "Count:"+waypointCount);
		waypoints.clear();
		requestWayPoint();
	}

	private void processReceivedWaypoint(msg_mission_item msg) {
		Double Lat = (double) msg.x;
		Double Lng = (double) msg.y;
		Double h = (double) msg.z;
		waypoints.add(new waypoint(Lat, Lng, h));
		Log.d("Mission", "Item:"+waypoints.size()+" Lng:"+Lng+" Lat:"+Lat+" h:"+h);
		
		if(waypoints.size()<waypointCount){
			requestWayPoint();
		}else{
			sendAck();
			onWaypointsReceived(waypoints);
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
	

	private void sendWaypointCount() {
		Log.d("Mission", "sendWaypointCount");
		msg_mission_count msg = new msg_mission_count();
		msg.target_system = 1;
		msg.target_component = 1;
		msg.count = (short) waypoints.size();
	    MAV.sendMavPacket(msg.pack());		
	}
	
	private void sendWaypoint(waypoint waypoint) {
		Log.d("Mission", "sendWaypoint");
		msg_mission_item msg = new msg_mission_item();
		msg.target_system = 1;
		msg.target_component = 1;
		msg.x = (float) waypoint.coord.latitude;
		msg.y = (float) waypoint.coord.longitude;
		msg.z = waypoint.Height.floatValue();
		// TODO add all the other parameters
		Log.d("Mission", msg.toString());
	    MAV.sendMavPacket(msg.pack());				
	}
	
}

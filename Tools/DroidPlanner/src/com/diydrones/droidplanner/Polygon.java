package com.diydrones.droidplanner;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Polygon {

	private List<waypoint> waypoints;
	private boolean isVisible;

	public Polygon() {
		waypoints = new ArrayList<waypoint>();
		setVisible(false);
	}

	public PolylineOptions getFlightPath() {
		PolylineOptions flightPath = new PolylineOptions();
		flightPath.color(Color.BLACK).width(2);

		for (waypoint point : waypoints) {
			flightPath.add(point.coord);
		}
		if(waypoints.size()>2){
			flightPath.add(waypoints.get(0).coord);
		}
		
		return flightPath;
	}

	public List<MarkerOptions> getWaypointMarkers() {
		int i = 1;
		List<MarkerOptions> MarkerList = new ArrayList<MarkerOptions>();
		for (waypoint point : waypoints) {
			MarkerList.add(new MarkerOptions().position(point.coord)
					.draggable(true).title("Poly" + Integer.toString(i))
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			i++;
		}
		return MarkerList;
	}

	public void addWaypoint(Double Lat, Double Lng) {
		waypoints.add(new waypoint(Lat, Lng, (Double) 0.0));
	}

	public void addWaypoint(LatLng coord) {
		waypoints.add(new waypoint(coord,(Double) 0.0));
	}

	public void clearPolygon() {
		waypoints.clear();
	}
	
	public boolean isPolygonMarker(Marker marker) {
		return marker.getTitle().contains("Poly");
	}

	public void setWaypointToMarker(Marker marker) {
		int WPnumber = Integer.parseInt(marker.getTitle().replace("Poly", "")) - 1;
		waypoints.get(WPnumber).coord = marker.getPosition();
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}

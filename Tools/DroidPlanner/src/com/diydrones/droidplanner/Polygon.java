package com.diydrones.droidplanner;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.util.Log;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Polygon {

	private List<waypoint> waypoints;
	private boolean isVisible;

	public Polygon() {
		waypoints = new ArrayList<waypoint>();
		setVisible(true); // for debugging
	}

	public PolylineOptions getFlightPath() {
		PolylineOptions flightPath = new PolylineOptions();
		flightPath.color(Color.BLACK).width(2);

		for (waypoint point : waypoints) {
			flightPath.add(point.coord);
		}
		if (waypoints.size() > 2) {
			flightPath.add(waypoints.get(0).coord);
		}

		return flightPath;
	}

	public List<MarkerOptions> getWaypointMarkers() {
		int i = 1;
		List<MarkerOptions> MarkerList = new ArrayList<MarkerOptions>();
		for (waypoint point : waypoints) {
			MarkerList.add(new MarkerOptions()
					.position(point.coord)
					.draggable(true)
					.title("Poly" + Integer.toString(i))
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			i++;
		}
		return MarkerList;
	}

	public void addWaypoint(Double Lat, Double Lng) {
		waypoints.add(new waypoint(Lat, Lng, (Double) 0.0));
	}

	public void addWaypoint(LatLng coord) {
		waypoints.add(new waypoint(coord, (Double) 0.0));
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

	public class Bounds {
		public LatLng sw;
		public LatLng se;
		public LatLng nw;
		public LatLng ne;

		public Bounds(List<waypoint> points) {
			LatLngBounds.Builder builder = new LatLngBounds.Builder();
			for (waypoint point : points) {
				builder.include(point.coord);
			}
			LatLngBounds bounds = builder.build();
			sw = bounds.southwest;
			se = new LatLng(bounds.southwest.latitude,
					bounds.northeast.longitude);
			nw = new LatLng(bounds.northeast.latitude,
					bounds.southwest.longitude);
			ne = bounds.northeast;
		}

		public double getWidth() {
			return (ne.longitude - nw.longitude);
		}

		public double getHeight() {
			return (nw.latitude - sw.latitude);
		}
		
		public double getDiag(){
		return getDistance(ne,sw);	
		}
	}

	public List<waypoint> hatchfill() {
		List<waypoint> grid = new ArrayList<waypoint>();
		
		Bounds bounds = new Bounds(waypoints); 
		
		
		Log.d("Hacth", "diag:" + bounds.getDiag());

		Double angle = 30.0;
		Double lineDist = 3.0;
		Double dx = lineDist/Math.sin(Math.toRadians(angle));
		Double dy = lineDist/Math.cos(Math.toRadians(angle));
		
		Log.d("Hacth", "Ang:" + angle + " lineDist:" + lineDist + " dy:" + dy
				+ " dx:" + dx);

		if (angle >= 0) {
			Double lat = bounds.se.latitude;
			Double lng = bounds.se.longitude;

			while (lng > bounds.sw.longitude ) {
				lng -= dx;
				grid.add(new waypoint(lat, lng, 0.0));
				grid.add(new waypoint(lat+bounds.getDiag()*dy, lng+bounds.getDiag()*dx, 0.0));				
			}
			while (lat < bounds.nw.latitude) {
				lat += dy;
				grid.add(new waypoint(lat, lng, 0.0));
				grid.add(new waypoint(lat+bounds.getDiag()*dy, lng+bounds.getDiag()*dx, 0.0));
			}

		}

		return grid;
	}

	public Double getDistance(LatLng p1, LatLng p2) {
		return (Math.hypot((p1.latitude - p2.latitude),
				(p1.longitude - p2.longitude)));
	}

}

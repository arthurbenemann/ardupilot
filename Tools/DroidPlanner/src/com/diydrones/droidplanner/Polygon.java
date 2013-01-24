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

		public double getDiag() {
			return latToMeters(getDistance(ne, sw));
		}

		public LatLng getMiddle() {
			return (new LatLng((ne.latitude + sw.latitude) / 2,
					(ne.longitude + sw.longitude) / 2));

		}
	}

	public List<waypoint> hatchfill() {
		List<waypoint> grid = new ArrayList<waypoint>();
		
		Bounds bounds = new Bounds(waypoints); 
		
		
		Log.d("Hacth", "diag:" + bounds.getDiag());

		Double angle = 0.0;
		Double lineDist = 20000.0;
		Double y1 = Math.cos(Math.toRadians(angle+90));
		Double x1 = Math.sin(Math.toRadians(angle+90));
		
		LatLng point = new LatLng(bounds.getMiddle().latitude,bounds.getMiddle().longitude);
		point = newpos(point, angle-135, bounds.getDiag());
                
        // get x y step amount in lat lng from m
        LatLng diff = new LatLng(metersTolat(lineDist * y1),metersTolat(lineDist * x1));
        Log.d("Diff", "Lat:"+metersTolat(lineDist * y1)+" Long:"+metersTolat(lineDist * x1));

        int lines = 0;
        while (lines * lineDist < bounds.getDiag() * 1.5)
        {
        	grid.add(new waypoint(point, 0.0)); //debug
            LatLng pointx = point;
            pointx = newpos(pointx, angle, bounds.getDiag() * 1.5);
            grid.add(new waypoint(pointx, 0.0));//debug

            /*linelatlng line = new linelatlng();
            line.p1 = new PointLatLng(y, x);
            line.p2 = new PointLatLng(ny, nx);
            line.basepnt = new PointLatLng(y, x);
            grid.Add(line);
*/
            point = addLatLng(point,diff);
            lines++;
        }
		return grid;
	}

	private LatLng addLatLng(LatLng point, LatLng diff) {
		return (new LatLng(point.latitude+diff.latitude,point.longitude+diff.longitude));
	}

	public Double getDistance(LatLng p1, LatLng p2) {
		return (Math.hypot((p1.latitude - p2.latitude),
				(p1.longitude - p2.longitude)));
	}
	
	
	public Double latToMeters(double lat){
		double radius_of_earth = 6378100.0;// # in meters
		return Math.toRadians(lat)*radius_of_earth;
	}
	
	public Double metersTolat(double meters){
		double radius_of_earth = 6378100.0;// # in meters
		return Math.toDegrees(meters/radius_of_earth);
	}

	public LatLng newpos(LatLng point, double bearing, double distance) {
		// '''extrapolate latitude/longitude given a heading and distance
		// thanks to http://www.movable-type.co.uk/scripts/latlong.html
		// '''
		// from math import sin, asin, cos, atan2, radians, degrees
		double radius_of_earth = 6378100.0;// # in meters

		double lat = point.latitude;
		double lon = point.longitude;
		double lat1 = Math.toRadians(lat);
		double lon1 = Math.toRadians(lon);
		double brng = Math.toRadians(bearing);
		double dr = distance / radius_of_earth;

		double lat2 = Math.asin(Math.sin(lat1) * Math.cos(dr) + Math.cos(lat1)
				* Math.sin(dr) * Math.cos(brng));
		double lon2 = lon1
				+ Math.atan2(Math.sin(brng) * Math.sin(dr) * Math.cos(lat1),
						Math.cos(dr) - Math.sin(lat1) * Math.sin(lat2));

		return (new LatLng(Math.toDegrees(lat2), Math.toDegrees(lon2)));
	}
}

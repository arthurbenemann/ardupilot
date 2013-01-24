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

	public class linelatlng {
		public LatLng p1;
		public LatLng p2;
		// used as a base for grid along line
		public LatLng basepnt;

		public linelatlng(LatLng p1, LatLng p2, LatLng basepnt) {
			this.p1 = p1;
			this.p2 = p2;
			this.basepnt = basepnt;
		}
	}

	public List<waypoint> hatchfill() {
		List<waypoint> gridPoints = new ArrayList<waypoint>();
		List<linelatlng> gridLines = new ArrayList<linelatlng>();
		Bounds bounds = new Bounds(waypoints);

		Log.d("Hacth", "diag:" + bounds.getDiag());

		Double angle = 0.0;
		Double lineDist = 5000.0;
		Double y1 = Math.cos(Math.toRadians(angle + 90));
		Double x1 = Math.sin(Math.toRadians(angle + 90));

		LatLng point = new LatLng(bounds.getMiddle().latitude,
				bounds.getMiddle().longitude);
		point = newpos(point, angle - 135, bounds.getDiag());

		// get x y step amount in lat lng from m
		LatLng diff = new LatLng(metersTolat(lineDist * y1),
				metersTolat(lineDist * x1));
		Log.d("Diff", "Lat:" + metersTolat(lineDist * y1) + " Long:"
				+ metersTolat(lineDist * x1));

		// draw grid
		int lines = 0;
		while (lines * lineDist < bounds.getDiag() * 1.5) {
			// gridPoints.add(new waypoint(point, 0.0)); // debug
			LatLng pointx = point;
			pointx = newpos(pointx, angle, bounds.getDiag() * 1.5);
			// gridPoints.add(new waypoint(pointx, 0.0));// debug

			linelatlng line = new linelatlng(point, pointx, point);
			gridLines.add(line);

			point = addLatLng(point, diff);
			lines++;
		}

		// find intersections
		for (linelatlng line : gridLines) {
			// double noc = Double.MAX_VALUE;
			// double nof = Double.MIN_VALUE;

			// LatLng closestlatlong = LatLng.Zero;
			// LatLng farestlatlong = LatLng.Zero;

			// List<LatLng> intersections = new ArrayList<LatLng>();

			// int crosses = 0;
			for (int b = 0; b < waypoints.size(); b++) {
				LatLng newlatlong;
				if (b != waypoints.size() - 1) {
					newlatlong = FindLineIntersection(waypoints.get(b).coord,
							waypoints.get(b + 1).coord, line.p1, line.p2);
				} else {	// Don't forget the last polygon line
					newlatlong = FindLineIntersection(waypoints.get(b).coord,
							waypoints.get(0).coord, line.p1, line.p2);
				}

				if (newlatlong != null) {
					gridPoints.add(new waypoint(newlatlong, 0.0));// debug
				}
				/*
				 * if (!newlatlong.IsZero) { crosses++; matchs.Add(newlatlong);
				 * if (noc > MainMap.Manager.GetDistance(gridLines[a].p1,
				 * newlatlong)) { closestlatlong.Lat = newlatlong.Lat;
				 * closestlatlong.Lng = newlatlong.Lng; noc =
				 * MainMap.Manager.GetDistance(gridLines[a].p1, newlatlong); }
				 * if (nof < MainMap.Manager.GetDistance(gridLines[a].p1,
				 * newlatlong)) { farestlatlong.Lat = newlatlong.Lat;
				 * farestlatlong.Lng = newlatlong.Lng; nof =
				 * MainMap.Manager.GetDistance(gridLines[a].p1, newlatlong); } }
				 */
			}
			/*
			 * if (crosses == 0) { if (!PointInPolygon(gridLines[a].p1,
			 * area.Points) && !PointInPolygon(gridLines[a].p2, area.Points))
			 * remove.Add(gridLines[a]); } else if (crosses == 1) {
			 * 
			 * } else if (crosses == 2) { linelatlng line = gridLines[a];
			 * line.p1 = closestlatlong; line.p2 = farestlatlong; gridLines[a] =
			 * line; } else { linelatlng line = gridLines[a]; remove.Add(line);
			 * 
			 * while (matchs.Count > 1) { linelatlng newline = new linelatlng();
			 * 
			 * closestlatlong = findClosestPoint(closestlatlong, matchs);
			 * newline.p1 = closestlatlong; matchs.Remove(closestlatlong);
			 * 
			 * closestlatlong = findClosestPoint(closestlatlong, matchs);
			 * newline.p2 = closestlatlong; matchs.Remove(closestlatlong);
			 * 
			 * newline.basepnt = line.basepnt;
			 * 
			 * gridLines.Add(newline); } if (a > 150) break; }
			 */
		}

		return gridPoints;
	}

	/*
	 * Finds the intersection of two lines returns the intersection point or
	 * null if there is no intersection from:
	 * http://stackoverflow.com/questions/
	 * 1119451/how-to-tell-if-a-line-intersects -a-polygon-in-c
	 */
	private LatLng FindLineIntersection(LatLng start1, LatLng end1,
			LatLng start2, LatLng end2) {
		double denom = ((end1.longitude - start1.longitude) * (end2.latitude - start2.latitude))
				- ((end1.latitude - start1.latitude) * (end2.longitude - start2.longitude));
		// AB & CD are parallel
		if (denom == 0)
			return null;
		double numer = ((start1.latitude - start2.latitude) * (end2.longitude - start2.longitude))
				- ((start1.longitude - start2.longitude) * (end2.latitude - start2.latitude));
		double r = numer / denom;
		double numer2 = ((start1.latitude - start2.latitude) * (end1.longitude - start1.longitude))
				- ((start1.longitude - start2.longitude) * (end1.latitude - start1.latitude));
		double s = numer2 / denom;
		if ((r < 0 || r > 1) || (s < 0 || s > 1))
			return null;
		// Find intersection point
		double longitude = start1.longitude
				+ (r * (end1.longitude - start1.longitude));
		double latitude = start1.latitude
				+ (r * (end1.latitude - start1.latitude));
		return (new LatLng(latitude, longitude));
	}

	private LatLng addLatLng(LatLng point, LatLng diff) {
		return (new LatLng(point.latitude + diff.latitude, point.longitude
				+ diff.longitude));
	}

	public Double getDistance(LatLng p1, LatLng p2) {
		return (Math.hypot((p1.latitude - p2.latitude),
				(p1.longitude - p2.longitude)));
	}

	public Double latToMeters(double lat) {
		double radius_of_earth = 6378100.0;// # in meters
		return Math.toRadians(lat) * radius_of_earth;
	}

	public Double metersTolat(double meters) {
		double radius_of_earth = 6378100.0;// # in meters
		return Math.toDegrees(meters / radius_of_earth);
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

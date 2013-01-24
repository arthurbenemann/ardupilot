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

	public class LineLatLng {
		public LatLng p1;
		public LatLng p2;

		public LineLatLng(LatLng p1, LatLng p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}

	public List<waypoint> hatchfill() {
		List<waypoint> gridPoints = new ArrayList<waypoint>();

		Double angle = 0.0;
		Double lineDist = 5000.0;
		List<LineLatLng> gridLines = generateGrid(waypoints, angle, lineDist);

		List<LineLatLng> hatchLines = findIntersections(waypoints, gridLines);

		boolean dir = false;
		for (LineLatLng line : hatchLines) {
			if (dir) {
				gridPoints.add(new waypoint(line.p1, 0.0));// debug
				gridPoints.add(new waypoint(line.p2, 0.0));// debug
			} else {
				gridPoints.add(new waypoint(line.p2, 0.0));// debug
				gridPoints.add(new waypoint(line.p1, 0.0));// debug
			}
			dir = !dir;
		}
		return gridPoints;
	}

	/**
	 * 
	 * @param polygon
	 *            Polygon points
	 * @param grid
	 *            array with Grid lines
	 * @return array with the hatch lines
	 */
	private List<LineLatLng> findIntersections(List<waypoint> polygon,
			List<LineLatLng> grid) {
		List<LineLatLng> hatchLines = new ArrayList<LineLatLng>();
		// find intersections
		for (LineLatLng line : grid) {
			double closestDistance = Double.MAX_VALUE;
			double farestDistance = Double.MIN_VALUE;

			LatLng closestPoint = null;
			LatLng farestPoint = null;

			int crosses = 0;

			for (int b = 0; b < waypoints.size(); b++) {
				LatLng newlatlong;
				if (b != waypoints.size() - 1) {
					newlatlong = FindLineIntersection(waypoints.get(b).coord,
							waypoints.get(b + 1).coord, line.p1, line.p2);
				} else { // Don't forget the last polygon line
					newlatlong = FindLineIntersection(waypoints.get(b).coord,
							waypoints.get(0).coord, line.p1, line.p2);
				}

				if (newlatlong != null) {
					crosses++;
					if (closestDistance > getDistance(line.p1, newlatlong)) {
						closestPoint = new LatLng(newlatlong.latitude,
								newlatlong.longitude);
						closestDistance = getDistance(line.p1, newlatlong);
					}
					if (farestDistance < getDistance(line.p1, newlatlong)) {
						farestPoint = new LatLng(newlatlong.latitude,
								newlatlong.longitude);
						farestDistance = getDistance(line.p1, newlatlong);
					}
				}
			}

			switch (crosses) {
			case 0:
			case 1:
				break;
			default: // TODO handle multiple crossings in a better way
			case 2:
				hatchLines.add(new LineLatLng(closestPoint, farestPoint));
				break;
			}
		}
		return hatchLines;
	}

	/**
	 * Generates a grid over the specified boundary's
	 * 
	 * @param waypoints
	 *            Array with the polygon points
	 * @param angle
	 *            Angle of the grid in Degrees
	 * @param lineDist
	 *            Distance between lines in meters
	 * @return Returns a array of lines of the generated grid
	 */
	private List<Polygon.LineLatLng> generateGrid(List<waypoint> waypoints,
			Double angle, Double lineDist) {
		List<Polygon.LineLatLng> gridLines = new ArrayList<Polygon.LineLatLng>();

		Bounds bounds = new Bounds(waypoints);
		LatLng point = new LatLng(bounds.getMiddle().latitude,
				bounds.getMiddle().longitude);

		point = newpos(point, angle - 135, bounds.getDiag());

		// get x y step amount in lat lng from m
		Double y1 = Math.cos(Math.toRadians(angle + 90));
		Double x1 = Math.sin(Math.toRadians(angle + 90));
		LatLng diff = new LatLng(metersTolat(lineDist * y1),
				metersTolat(lineDist * x1));
		Log.d("Diff", "Lat:" + metersTolat(lineDist * y1) + " Long:"
				+ metersTolat(lineDist * x1));

		// draw grid
		int lines = 0;
		while (lines * lineDist < bounds.getDiag() * 1.5) {
			LatLng pointx = point;
			pointx = newpos(pointx, angle, bounds.getDiag() * 1.5);

			Polygon.LineLatLng line = new Polygon.LineLatLng(point, pointx);
			gridLines.add(line);

			point = addLatLng(point, diff);
			lines++;
		}

		return gridLines;
	}

	/**
	 * 
	 * Object for holding boundary for a polygon
	 * 
	 */
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

	/**
	 * Finds the intersection of two lines
	 * http://stackoverflow.com/questions/
	 * 1119451/how-to-tell-if-a-line-intersects -a-polygon-in-c
	 * 
	 * @param start1 starting point of the first line
	 * @param end1 ending point of the first line
	 * @param start2 starting point of the second line
	 * @param end2 ending point of the second line
	 * @return point of intersection, or null if there is no intersection
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

	/**
	 * Finds the line that has the start or tip closest to a point.
	 * 
	 * @param point
	 *            Point to the distance will be minimized
	 * @param list
	 *            A list of lines to search
	 * @return The closest Line
	 */
	LineLatLng findClosestLine(LatLng point, List<LineLatLng> list) {
		LineLatLng answer = list.get(0);
		double shortest = Double.MAX_VALUE;

		for (LineLatLng line : list) {
			double ans1 = getDistance(point, line.p1);
			double ans2 = getDistance(point, line.p2);
			LatLng shorterpnt = ans1 < ans2 ? line.p1 : line.p2;

			if (shortest > getDistance(point, shorterpnt)) {
				answer = line;
				shortest = getDistance(point, shorterpnt);
			}
		}
		return answer;
	}

	/**
	 * Finds the closest point in a list to another point
	 * 
	 * @param point
	 *            point that will be used as reference
	 * @param list
	 *            List of points to be searched
	 * @return The closest point
	 */
	LatLng findClosestPoint(LatLng point, List<LatLng> list) {
		LatLng answer = null;
		double currentbest = Double.MAX_VALUE;

		for (LatLng pnt : list) {
			double dist1 = getDistance(point, pnt);

			if (dist1 < currentbest) {
				answer = pnt;
				currentbest = dist1;
			}
		}
		return answer;
	}

	/**
	 * Adds an offset to a point (in degrees)
	 * 
	 * @param point
	 *            the point to be modified
	 * @param offset
	 *            offset to be added
	 * @return point with offset
	 */
	private LatLng addLatLng(LatLng point, LatLng offset) {
		return (new LatLng(point.latitude + offset.latitude, point.longitude
				+ offset.longitude));
	}

	/**
	 * Returns the distance between two points
	 * 
	 * @return distance between the points in degrees
	 */
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

	/**
	 * Extrapolate latitude/longitude given a heading and distance thanks to
	 * http://www.movable-type.co.uk/scripts/latlong.html
	 * 
	 * @param origin
	 *            Point of origin
	 * @param bearing
	 *            bearing to navigate
	 * @param distance
	 *            distance to be added
	 * @return New point with the added distance
	 */
	public LatLng newpos(LatLng origin, double bearing, double distance) {
		double radius_of_earth = 6378100.0;// # in meters

		double lat = origin.latitude;
		double lon = origin.longitude;
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

package com.diydrones.droidplanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.diydrones.droidplanner.MissionManager.waypoint;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;

public class GCPActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {
	private GoogleMap mMap;

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set up the action bar to show a dropdown list.
		setUpActionBar();

		setContentView(R.layout.gcp);

		setUpMapIfNeeded();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_gcp, menu);

		return true;
	}

	private void setUpActionBar() {
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
				R.array.menu_dropdown,
				android.R.layout.simple_spinner_dropdown_item);
		actionBar.setListNavigationCallbacks(mSpinnerAdapter, this);
		actionBar.setSelectedNavigationItem(4);
	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		if (mMap == null) {
			// Try to obtain the map from the SupportMapFragment.
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			// Check if we were successful in obtaining the map.
			if (mMap != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		mMap.setMyLocationEnabled(true);
		mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		// mMap.setOnMarkerDragListener(this);

		UiSettings mUiSettings = mMap.getUiSettings();
		mUiSettings.setMyLocationButtonEnabled(true);
		mUiSettings.setCompassEnabled(true);
		mUiSettings.setTiltGesturesEnabled(false);

		// mMap.setOnMapLongClickListener(this);
		// updateMarkersAndPath();
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		switch (itemPosition) {
		default:
		case 0: // Planning
			startActivity(new Intent(this, PlanningActivity.class));
			return false;
		case 1: // Flight Data
			startActivity(new Intent(this, FightDataActivity.class));
			return false;
		case 2: // PID
			startActivity(new Intent(this, PIDActivity.class));
			return false;
		case 3: // Terminal
			startActivity(new Intent(this, TerminalActivity.class));
			return false;
		case 4: // GCP
			// startActivity(new Intent(this, GCPActivity.class));
			return false;
		}
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_clear:
			// clearWaypointsAndUpdate();
			return true;
		case R.id.menu_open_kmz:
				openKMZ();
			
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	private void openKMZ()  {
		try {
		FileInputStream in = new FileInputStream(Environment
				.getExternalStorageDirectory().toString()
				+ "/waypoints/file.kml");
		new KmlParser().parse(in);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (XmlPullParserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}

	/**
	 * Class to parse a Kml file, based on the code from
	 * http://developer.android.com/training/basics/network-ops/xml.html
	 * 
	 */
	public class KmlParser {
		private final String ns = null;

		public List<waypoint> parse(InputStream in)
				throws XmlPullParserException, IOException {
			try {
				XmlPullParser parser = Xml.newPullParser();
				parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,
						false);
				parser.setInput(in, null);
				parser.nextTag();
				return readFeed(parser);
			} finally {
				in.close();
			}
		}

		private List<waypoint> readFeed(XmlPullParser parser)
				throws XmlPullParserException, IOException {
			List<waypoint> entries = new ArrayList<waypoint>();

			parser.require(XmlPullParser.START_TAG, ns, "kml");
			while (parser.next() != XmlPullParser.END_TAG) {
				if (parser.getEventType() != XmlPullParser.START_TAG) {
					continue;
				}
				String name = parser.getName();
				// Starts by looking for the entry tag
				if (name.equals("Placemark")) {
					entries.add(readPlacemark(parser));
				} else {
					skip(parser);
				}
			}
			return entries;
		}

		private waypoint readPlacemark(XmlPullParser parser)
				throws XmlPullParserException, IOException {
			parser.require(XmlPullParser.START_TAG, ns, "Placemark");
			waypoint point = null;

			while (parser.next() != XmlPullParser.END_TAG) {
				if (parser.getEventType() != XmlPullParser.START_TAG) {
					continue;
				}
				String name = parser.getName();
				if (name.equals("Point")) {
					point = readPoint(parser);
				} else {
					skip(parser);
				}
			}
			return point;
		}

		// Processes title tags in the feed.
		private waypoint readPoint(XmlPullParser parser) throws IOException,
				XmlPullParserException {
			//parser.require(XmlPullParser.START_TAG, ns, "coordinates");
			String title = readText(parser);
			//parser.require(XmlPullParser.END_TAG, ns, "coordinates");
			Log.d("", "coord:" + title);
			return null;
		}

		// For the tags title and summary, extracts their text values.
		private String readText(XmlPullParser parser) throws IOException,
				XmlPullParserException {
			String result = "";
			if (parser.next() == XmlPullParser.TEXT) {
				result = parser.getText();
				parser.nextTag();
			}
			return result;
		}

		// Skips tags the parser isn't interested in. Uses depth to handle
		// nested tags. i.e.,
		// if the next tag after a START_TAG isn't a matching END_TAG, it keeps
		// going until it
		// finds the matching END_TAG (as indicated by the value of "depth"
		// being 0).
		private void skip(XmlPullParser parser) throws XmlPullParserException,
				IOException {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				throw new IllegalStateException();
			}
			int depth = 1;
			while (depth != 0) {
				switch (parser.next()) {
				case XmlPullParser.END_TAG:
					depth--;
					break;
				case XmlPullParser.START_TAG:
					depth++;
					break;
				}
			}
		}
	}
}

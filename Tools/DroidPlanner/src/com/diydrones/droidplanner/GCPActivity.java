package com.diydrones.droidplanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.diydrones.droidplanner.KmlParser.waypoint;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

public class GCPActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {
	private GoogleMap mMap;
	private	List<waypoint> WPlist;
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
		
		WPlist = new ArrayList<waypoint>();

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
		updateMarkers();
	}

	private void updateMarkers() {
		mMap.clear();
		for (waypoint point : WPlist) {
			mMap.addMarker(new MarkerOptions()
					.position(point.coord)
					.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.placemark_circle_highlight))
					.anchor((float) 0.5, (float) 0.5));
		}		
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

	private void openKMZ() {
		try {
			FileInputStream in = new FileInputStream(Environment
					.getExternalStorageDirectory().toString()
					+ "/waypoints/file.kml");
			KmlParser reader = new KmlParser();

			WPlist = reader.parse(in);
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
		updateMarkers();
	}
}

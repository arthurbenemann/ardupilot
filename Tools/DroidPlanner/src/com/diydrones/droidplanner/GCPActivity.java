package com.diydrones.droidplanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.diydrones.droidplanner.KmlParser.waypoint;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GCPActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener, OnMarkerClickListener {
	private GoogleMap mMap;

	private List<waypoint> WPlist;

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

		UiSettings mUiSettings = mMap.getUiSettings();
		mUiSettings.setMyLocationButtonEnabled(true);
		mUiSettings.setCompassEnabled(true);
		mUiSettings.setTiltGesturesEnabled(false);

		mMap.setOnMarkerClickListener(this);
		updateMarkers();
	}

	private void updateMarkers() {
		int i = 1;
		mMap.clear();
		for (waypoint point : WPlist) {
			if (point.set) {
				mMap.addMarker(new MarkerOptions()
						.position(point.coord)
						.title(String.valueOf(i))
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.placemark_circle_blue))
						.anchor((float) 0.5, (float) 0.5));
			} else {
				mMap.addMarker(new MarkerOptions()
						.position(point.coord)
						.title(String.valueOf(i))
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.placemark_circle_red))
						.anchor((float) 0.5, (float) 0.5));
			}
			i++;
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
			clearWaypointsAndUpdate();
			return true;
		case R.id.menu_open_kmz:
			OpenKmzDialog();
			return true;
		case R.id.menu_zoom:
			zoomToExtents();
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	private void clearWaypointsAndUpdate() {
		WPlist.clear();
		updateMarkers();
	}

	public void zoomToExtents() {
		if (!WPlist.isEmpty()) {
			LatLngBounds.Builder builder = new LatLngBounds.Builder();
			for (waypoint point : WPlist) {
				builder.include(point.coord);
			}
			mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(
					builder.build(), 30));
		}
	}

	private boolean openKMZ(String filename) {
		try {
			FileInputStream in = new FileInputStream(Environment
					.getExternalStorageDirectory().toString()
					+ "/waypoints/"
					+ filename);
			KmlParser reader = new KmlParser();

			WPlist = reader.parse(in);
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		updateMarkers();
		zoomToExtents();
		return true;
	}

	private void OpenKmzDialog() {
		final String[] itemList = loadFileList();
		if (itemList.length == 0) {
			Toast.makeText(getApplicationContext(), R.string.no_waypoint_files,
					Toast.LENGTH_SHORT).show();
			return;
		}
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle(R.string.select_file_to_open);
		dialog.setItems(itemList, new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				if (openKMZ(itemList[which])) {
					zoomToExtents();
					Toast.makeText(getApplicationContext(), itemList[which],
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							R.string.error_when_opening_file,
							Toast.LENGTH_SHORT).show();
				}
				updateMarkers();
			}
		});
		dialog.create().show();
	}

	private String[] loadFileList() {
		File mPath = new File(Environment.getExternalStorageDirectory()
				.toString() + "/waypoints/");
		try {
			mPath.mkdirs();
		} catch (SecurityException e) {
			return new String[0];
		}
		if (mPath.exists()) {
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					return filename.contains(".kml");
				}
			};
			return mPath.list(filter);
		} else {
			return new String[0];
		}

	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		Log.d("marker", marker.getTitle());
		int i = Integer.parseInt(marker.getTitle()) - 1;
		WPlist.get(i).set = !WPlist.get(i).set;
		updateMarkers();
		return true;
	}
}

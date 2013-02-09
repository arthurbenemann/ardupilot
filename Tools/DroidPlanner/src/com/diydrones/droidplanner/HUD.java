package com.diydrones.droidplanner;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class HUD  extends android.support.v4.app.FragmentActivity
	implements OnNavigationListener {

	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			// Set up the action bar to show a dropdown list.
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
					R.array.menu_dropdown,
					android.R.layout.simple_spinner_dropdown_item);

			actionBar.setListNavigationCallbacks(mSpinnerAdapter, this);
			actionBar.setSelectedNavigationItem(1);

			setContentView(R.layout.flightdata);
		}
		



		@Override
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			switch (itemPosition) {
			default:
			case 0: // Planning
				startActivity(new Intent(this, PlanningActivity.class));
				return false;
			case 1: // HUD
				startActivity(new Intent(this, HUD.class));
				return false;
			case 2: // Flight Data
				startActivity(new Intent(this, FightDataActivity.class));
				return false;
			case 3: // PID
				startActivity(new Intent(this, PIDActivity.class));
				return false;
			case 4: // Terminal
				startActivity(new Intent(this, TerminalActivity.class));
				return false;
			case 5: // GCP
				startActivity(new Intent(this, GCPActivity.class));
				return false;
			}
		}
		
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.menu_flightdata, menu);

			return true;
		}
		@Override
		public boolean onMenuItemSelected(int featureId, MenuItem item) {
			switch (item.getItemId()) {
			case R.id.menu_settings:
				return true;
			case R.id.menu_connect:
				return true;
			default:
				return super.onMenuItemSelected(featureId, item);
			}
		}

}

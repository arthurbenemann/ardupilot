package com.diydrones.droidplanner;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.MAVLink.MAVLink;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;

public class HUDActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {

	HUDwidget hudWidget;
	public boolean running;
	MenuItem connectButton;
	
	MAVLink MAV = new MAVLink() {		
		@Override
		public void onReceiveMessage(MAVLinkMessage msg) {
			if(msg.msgid == msg_attitude.MAVLINK_MSG_ID_ATTITUDE){
				msg_attitude m = (msg_attitude) msg;
				hudWidget.newFlightData(m.roll, m.pitch, m.yaw);
			}			
		}
		
		@Override
		public void onConnect() {
			connectButton.setTitle(getResources().getString(R.string.menu_disconnect));
		}

		@Override
		public void onDisconnect() {		
			connectButton.setTitle(getResources().getString(R.string.menu_connect));
		}
	};

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

		setContentView(R.layout.hud);

		hudWidget = (HUDwidget) findViewById(R.id.hudWidget);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		switch (itemPosition) {
		default:
		case 0: // Planning
			startActivity(new Intent(this, PlanningActivity.class));
			return false;
		case 1: // HUD
			// startActivity(new Intent(this, HUDActivity.class));
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
		connectButton = menu.findItem(R.id.menu_connect);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_settings:
			byte[] buff = new byte[1];
			buff[0] = '1';
			MAV.sendBuffer(buff); // TODO only used for debbuging
			return true;
		case R.id.menu_connect:
			MAV.toggleConnectionState();
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}



}

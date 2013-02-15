package com.diydrones.droidplanner;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_mission_ack;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_param_value;
import com.MAVLink.Messages.ardupilotmega.msg_statustext;

public class TerminalActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {


	TextView terminal;
	Button sendButton;
	Menu menu;
	MenuItem connectButton;
	
	public MAVLinkClient MAVClient = new MAVLinkClient(this) {
		
		String additionalInfo="";
		@Override
		public void notifyReceivedData(MAVLinkMessage m) {
				String terminalMsg = "Received lenght packets\nLast packet was: " + m.msgid + "\n";
				if(m.msgid == msg_statustext.MAVLINK_MSG_ID_STATUSTEXT){
					additionalInfo+= ((msg_statustext) m).toString()+"\n";
				}
				if(m.msgid == msg_param_value.MAVLINK_MSG_ID_PARAM_VALUE){
					Log.d("PARAM",("param:"+new String(((msg_param_value) m).param_id)+"\t Value"+((msg_param_value) m).param_value));
				}
				
				terminal.setText(terminalMsg+additionalInfo);
		}
		
		@Override
		public void notifyDisconnected() {
			connectButton.setTitle(getResources().getString(R.string.menu_connect));
		}
			
		@Override
		public void notifyConnected() {
			connectButton.setTitle(getResources().getString(R.string.menu_disconnect));
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
		actionBar.setSelectedNavigationItem(4);

		setContentView(R.layout.terminal);

		terminal = (TextView) findViewById(R.id.textViewTerminal);
		sendButton = (Button) findViewById(R.id.buttonSend);
		
		MAVClient.init();
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		MAVClient.onDestroy();
	}
	
	public void sendData(View view) {
		Log.d("PARAM", "request List");
		msg_param_request_list msg = new msg_param_request_list();
		msg.target_system = 1;
		msg.target_component = 1;
		MAVClient.sendMavPacket(msg.pack());
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		switch (itemPosition) {
		default:
		case 0: // Planning
			startActivity(new Intent(this, PlanningActivity.class));
			return false;
		case 1: // HUD
			startActivity(new Intent(this, HUDActivity.class));
			return false;
		case 2: // Flight Data
			startActivity(new Intent(this, FightDataActivity.class));
			return false;
		case 3: // PID
			startActivity(new Intent(this, PIDActivity.class));
			return false;
		case 4: // Terminal
			//startActivity(new Intent(this, TerminalActivity.class));
			return false;
		case 5: // GCP
			startActivity(new Intent(this, GCPActivity.class));
			return false;
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_terminal, menu);
		this.menu = menu;
		connectButton = menu.findItem(R.id.menu_connect);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_settings:
			return true;
		case R.id.menu_connect:
			MAVClient.sendConnectMessage();			
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}
	
}

package com.diydrones.droidplanner;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.MAVLink.Parser;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;

public class HUDActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {

	HUDwidget hudWidget;
	public boolean running;

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

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_settings:
			sendMessage("1"); // TODO only used for debbuging
			return true;
		case R.id.menu_connect:
			openConnection();
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	private void openConnection() {
		Log.d("TCP IN", "starting TCP");
		running = true;
		new connectTask().execute("");
	}

	private BufferedInputStream in;
	public FileOutputStream logWriter;

	PrintWriter out;

	public void sendMessage(String message) {
		Log.d("TCP IN", "send");
		if (out != null && !out.checkError()) {
			out.println(message);
			out.flush();
		}
	}

	public class connectTask extends AsyncTask<String, msg_attitude, String> {
		public static final String SERVERIP = "10.0.0.99";
		public static final int SERVERPORT = 5760;

		public Parser parser;

		@Override
		protected String doInBackground(String... message) {
			Socket socket = null;
			parser = new Parser();
			try {

				InetAddress serverAddr = InetAddress.getByName(SERVERIP);
				socket = new Socket(serverAddr, SERVERPORT);
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				// receive the message which the server sends back
				in = new BufferedInputStream(socket.getInputStream());
				MAVLinkMessage m;
				while (running) {
					int data;
					if ((data = in.read()) >= 0) {
						m = parser.mavlink_parse_char(data);
						if (m != null) {
							if (m.msgid == msg_attitude.MAVLINK_MSG_ID_ATTITUDE) {
								publishProgress((msg_attitude) m);
							}
						}
					}
				}
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.d("TCP IN", "Finished");
		}

		@Override
		protected void onProgressUpdate(msg_attitude... values) {
			super.onProgressUpdate(values);
			Log.d("ROLL", "pitch:" + values[0].pitch);
			hudWidget.newFlightData(values[0].roll, values[0].pitch, values[0].yaw);
		}

	}

}

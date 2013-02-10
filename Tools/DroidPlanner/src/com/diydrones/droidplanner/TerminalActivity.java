package com.diydrones.droidplanner;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.MAVLink.Parser;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_list;

public class TerminalActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {

	TextView terminal;
	Button sendButton;
	Menu menu;
	MenuItem connectButton;
	boolean running = false;
	
	
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
	}
	
	public void sendData(View view) {
	    Log.d("teste", "Sended");
	    sendMessage(sendButton.getText().toString());
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
			toggleConnectionState();				
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	private void toggleConnectionState() {
		if(!running){
			openConnection();
		}else {
			closeConnection();
		}
	}

	private void closeConnection() {
		Log.d("TCP IN", "closing TCP");
		connectButton.setTitle(getResources().getString(R.string.menu_connect));
		running = false;
	}

	private void openConnection() {
		Log.d("TCP IN", "starting TCP");
		connectButton.setTitle(getResources().getString(R.string.menu_disconnect));
		running = true;
		new connectTask().execute("");
	}

	/**
	 * Timestamp for logs in the Mission Planner Format
	 */
	private String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss",Locale.US);
		String timeStamp = sdf.format(new Date());
		return timeStamp;
	}
	
	
	
	private BufferedInputStream in;
	public FileOutputStream logWriter;
	
	BufferedOutputStream out;

	public void sendMessage(String message) {
		msg_param_request_list msg = new msg_param_request_list();
		msg.target_system = 1;
		msg.target_component = 1; 
		byte[] buffer = msg.pack().encodePacket();
		
		String str ="";
		for (int i = 0; i < buffer.length; i++) {
			str += Integer.toHexString(buffer[i] & 0xff)+".";
		}
		Log.d("BUFF", str);
		
		if (out != null) {
			try {
				out.write(buffer);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class connectTask extends AsyncTask<String, String, String> {
		public static final String SERVERIP = "10.0.0.99";
		public static final int SERVERPORT = 5760;

		public Parser parser;
		

		@Override
		protected String doInBackground(String... message) {
			Socket socket = null;
			parser = new Parser();
			try {

				logWriter = getFileStream();	
				
				InetAddress serverAddr = InetAddress.getByName(SERVERIP);
				socket = new Socket(serverAddr, SERVERPORT);

				out = new BufferedOutputStream((socket.getOutputStream()));
				Log.e("TCP Client", "C: Done.");
				// receive the message which the server sends back
				in = new BufferedInputStream(socket.getInputStream());
				int cnt = 0;
				MAVLinkMessage m;
				String attitudeString = "";
				while (running) {
					int data;
					if ((data = in.read()) >= 0) {
						logWriter.write(data);
						m = parser.mavlink_parse_char(data);
						if (m != null) {
							if (m.msgid == msg_attitude.MAVLINK_MSG_ID_ATTITUDE) {
							}
							cnt++;
							
							String terminalMsg = "Received " + cnt + " packets\nLast packet was: " + m.msgid+"\n";
							publishProgress(terminalMsg+attitudeString);
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
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			//Log.d("TCP IN", "Update:" + values[0]);
			terminal.setText(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.d("TCP IN", "Finished");
			closeConnection();
		}



	}

	private FileOutputStream getFileStream() throws FileNotFoundException {
		String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root+"/DroidPlanner/logs");
		myDir.mkdirs();
		File file = new File(myDir, getTimeStamp()+".tlog");
		if (file.exists())
			file.delete();
		FileOutputStream out = new FileOutputStream(file);
		return out;
	}
}

package com.diydrones.droidplanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class TerminalActivity extends android.support.v4.app.FragmentActivity
		implements OnNavigationListener {

	TextView terminal;
	Button sendButton;
	
	
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
		actionBar.setSelectedNavigationItem(3);

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
		case 1: // Flight Data
			startActivity(new Intent(this, FightDataActivity.class));
			return false;
		case 2: // PID
			startActivity(new Intent(this, PIDActivity.class));
			return false;
		case 3: // Terminal
			// startActivity(new Intent(this, TerminalActivity.class));
			return false;
		case 4: // GCP
			startActivity(new Intent(this, GCPActivity.class));
			return false;

		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_terminal, menu);

		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_settings:
			return true;
		case R.id.menu_connect:
			Log.d("TCP IN", "starting");
			new connectTask().execute("");
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}
	
	
	
	private BufferedReader in;
	PrintWriter out;

	public void sendMessage(String message) {
		if (out != null && !out.checkError()) {
			out.println(message);
			out.flush();
		}
	}
	
	public class connectTask extends AsyncTask<String, String, TCPClient> {
		public static final String SERVERIP = "192.168.7.140"; 
		public static final int SERVERPORT = 5760;

		@Override
		protected TCPClient doInBackground(String... message) {
			Socket socket = null;
			
			try {
				InetAddress serverAddr = InetAddress.getByName(SERVERIP);
				socket = new Socket(serverAddr, SERVERPORT);
				
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				Log.e("TCP Client", "C: Done.");
				// receive the message which the server sends back
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					int data;
					if((data = in.read())>=0){
						publishProgress(Character.toString((char) data));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}


		
		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			//Log.d("TCP IN", "Update:" + values[0]);
			//terminal.append(values[0]);
		}

		@Override
		protected void onPostExecute(TCPClient result) {
			super.onPostExecute(result);
			Log.d("TCP IN", "Executed");
		}

	}

}

package com.MAVLink;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;

public abstract class MAVLink {
	public static final String SERVERIP = "10.0.0.99";
	public static final int SERVERPORT = 5760;

	boolean connected = false;
	private BufferedInputStream mavIn;
	public FileOutputStream logWriter;
	BufferedOutputStream mavOut;
	public int receivedCount = 0;

	public abstract void onReceiveMessage(MAVLinkMessage msg);

	public abstract void onDisconnect();

	public abstract void onConnect();

	public class connectTask extends AsyncTask<String, MAVLinkMessage, String> {

		public Parser parser;

		@Override
		protected String doInBackground(String... message) {
			Socket socket = null;
			parser = new Parser();
			try {

				logWriter = getFileStream();

				InetAddress serverAddr = InetAddress.getByName(SERVERIP);
				socket = new Socket(serverAddr, SERVERPORT);

				mavOut = new BufferedOutputStream((socket.getOutputStream()));
				Log.e("TCP Client", "C: Done.");
				// receive the message which the server sends back
				mavIn = new BufferedInputStream(socket.getInputStream());

				MAVLinkMessage m;

				while (connected) {
					int data;
					if ((data = mavIn.read()) >= 0) {
						// logWriter.write(data);
						m = parser.mavlink_parse_char(data);
						if (m != null) {
							receivedCount++;
							publishProgress(m);
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
		protected void onProgressUpdate(MAVLinkMessage... values) {
			super.onProgressUpdate(values);
			onReceiveMessage(values[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.d("TCP IN", "Disconected");
			closeConnection();
		}
	}

	/**
	 * Format and send a Mavlink packet via the MAVlink stream
	 * @param packet MavLink packet to be transmitted
	 */
	public void sendMavPacket(MAVLinkPacket packet) {
		byte[] buffer = packet.encodePacket();
		sendBuffer(buffer);
	}

	/**
	 * Sends a buffer thought the MAVlink stream
	 * @param buffer Buffer with the data to be transmitted
	 */
	public void sendBuffer(byte[] buffer) {
		if (mavOut != null) {
			try {
				mavOut.write(buffer);
				mavOut.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Toggle the current state of the MAVlink connection. Starting and closing
	 * the as needed. May throw a onConnect or onDisconnect callback
	 */
	public void toggleConnectionState() {
		if (isConnected()) {
			closeConnection();
		} else {
			openConnection();
		}
	}

	/*
	 * Close the MAVlink Connection
	 */
	private void closeConnection() {
		Log.d("TCP IN", "closing TCP");
		connected = false;
		onDisconnect();
	}

	/**
	 * Start the MAVlink Connection
	 */
	private void openConnection() {
		Log.d("TCP IN", "starting TCP");
		connected = true;
		new connectTask().execute("");
		onConnect();
	}

	/**
	 * State of the MAVlink Connection
	 * 
	 * @return true for connected
	 */
	private boolean isConnected() {
		return connected;
	}

	/**
	 * Timestamp for logs in the Mission Planner Format
	 */
	private String getTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss",
				Locale.US);
		String timeStamp = sdf.format(new Date());
		return timeStamp;
	}

	/**
	 * Get a file Stream for logging purposes
	 * 
	 * @return output file stream for the log file
	 */
	private FileOutputStream getFileStream() throws FileNotFoundException {
		String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root + "/DroidPlanner/logs");
		myDir.mkdirs();
		File file = new File(myDir, getTimeStamp() + ".tlog");
		if (file.exists())
			file.delete();
		FileOutputStream out = new FileOutputStream(file);
		return out;
	}

}

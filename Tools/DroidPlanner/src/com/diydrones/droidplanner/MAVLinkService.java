package com.diydrones.droidplanner;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.MAVLink.MAVLink;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;

/**
 * http://developer.android.com/guide/components/bound-services.html#Messenger
 *
 */
public class MAVLinkService extends Service {

	public static final int MSG_SAY_HELLO = 1;
	public static final int MSG_RECEIVED_DATA = 2;
	public static final int MSG_DEVICE_DISCONNECTED = 3;
	public static final int MSG_DEVICE_CONNECTED = 4;
    public static final int MSG_REGISTER_CLIENT = 5;
    public static final int MSG_UNREGISTER_CLIENT = 6;
    public static final int MSG_CONNECT_DEVICE = 7;
    public static final int MSG_SEND_DATA = 8;
	
// Messaging
	ArrayList<Messenger> msgCenter = new ArrayList<Messenger>();
	final Messenger mMessenger = new Messenger(new IncomingHandler());
	 
    /**
     * Handler of incoming messages from clients.
     */	 
    @SuppressLint("HandlerLeak")	// TODO fix this error message
	class IncomingHandler extends Handler {

		@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_REGISTER_CLIENT:
                	Log.d("Service","Register Client");
                	synchronized (msgCenter) {
                    	if(!msgCenter.contains(msg.replyTo))
                    		msgCenter.add(msg.replyTo);
						
					}   
                	break;
                case MSG_UNREGISTER_CLIENT:
                	Log.d("Service","Unregister Client");
                	synchronized (msgCenter) {
                		msgCenter.remove(msg.replyTo);
                	}
                	break;
                   
                case MSG_CONNECT_DEVICE:
                	Log.d("Service","Toglle connection to Device");
                	MAV.toggleConnectionState();
                	break;
                	
                case MSG_SEND_DATA:
                	Log.d("Service","Sending packet");
                	Bundle b = msg.getData();
	            	MAVLinkPacket packet = (MAVLinkPacket) b.getSerializable("msg");
	            	MAV.sendMavPacket(packet);
                default:
                    super.handleMessage(msg);
            }
        }
    }
	
    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */    
	@Override
	public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
	}
	
	
	private void notifyNewMessage(MAVLinkMessage m) {
		try {
			synchronized (msgCenter) {
				for( Messenger c: msgCenter){
			    	if( c == null)
			    		continue;			    	
					Message msg = Message.obtain(null, MSG_RECEIVED_DATA);
					Bundle data = new Bundle();
					data.putSerializable("msg", m);
					msg.setData(data);			    	
			    	c.send(msg);			    	
			    }
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		
		}
	}
	
	private void sendMessage(int m) {
		try {
			synchronized (msgCenter) {
				for( Messenger c: msgCenter){
			    	if( c == null)
			    		continue;			    	
					Message msg = Message.obtain(null, m);   	
			    	c.send(msg);			    	
			    }
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		
		}
	}
	
	
	MAVLink MAV = new MAVLink() {

		@Override
		public void onReceiveMessage(MAVLinkMessage msg) {
			notifyNewMessage(msg);			
		}

		@Override
		public void onDisconnect() {
			sendMessage(MSG_DEVICE_DISCONNECTED);
			
		}

		@Override
		public void onConnect() {
			sendMessage(MSG_DEVICE_CONNECTED);
			
		}
	};

}

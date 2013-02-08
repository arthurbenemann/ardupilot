// MESSAGE AP_ADC PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import android.util.Log;

/**
* raw ADC output
*/
public class msg_ap_adc extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_AP_ADC = 153;
	public static final int MAVLINK_MSG_LENGTH = 12;

 	/**
	*ADC output 1
	*/
	public short adc1; 
 	/**
	*ADC output 2
	*/
	public short adc2; 
 	/**
	*ADC output 3
	*/
	public short adc3; 
 	/**
	*ADC output 4
	*/
	public short adc4; 
 	/**
	*ADC output 5
	*/
	public short adc5; 
 	/**
	*ADC output 6
	*/
	public short adc6; 

/**
 * Decode a ap_adc message into this class fields
 *
 * @param payload The message to decode
 */
    public void unpack(MAVLinkPayload payload) {
	    adc1 = payload.getShort();
	    adc2 = payload.getShort();
	    adc3 = payload.getShort();
	    adc4 = payload.getShort();
	    adc5 = payload.getShort();
	    adc6 = payload.getShort();    
    }

    public msg_ap_adc(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_AP_ADC;
        unpack(payload);
        Log.d("MAVLink", "AP_ADC");
    }
}

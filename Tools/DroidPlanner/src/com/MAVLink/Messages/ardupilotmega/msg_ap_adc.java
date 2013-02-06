// MESSAGE AP_ADC PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

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
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_ap_adc m = new msg_ap_adc();
	//m.adc1 = _get_adc1(msg);
	//m.adc2 = _get_adc2(msg);
	//m.adc3 = _get_adc3(msg);
	//m.adc4 = _get_adc4(msg);
	//m.adc5 = _get_adc5(msg);
	//m.adc6 = _get_adc6(msg);
    return m;	

    }
}

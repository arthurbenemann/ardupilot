package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;

public class msg_ap_adc extends MAVLinkMessage{

	public msg_ap_adc(){ messageType = MAVLINK_MSG_ID_AP_ADC; }

	public static final int MAVLINK_MSG_ID_AP_ADC = 153;

	private static final long serialVersionUID = MAVLINK_MSG_ID_AP_ADC;

	public int adc1; ///< ADC output 1
	public int adc2; ///< ADC output 2
	public int adc3; ///< ADC output 3
	public int adc4; ///< ADC output 4
	public int adc5; ///< ADC output 5
	public int adc6; ///< ADC output 6

}
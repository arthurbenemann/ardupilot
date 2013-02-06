// MESSAGE PARAM_REQUEST_LIST PACKING
package com.MAVLink.Messages.ardupilotmega;

import java.util.List;

import com.MAVLink.Messages.MAVLinkMessage;

/**
* Request all parameters of this component. After his request, all parameters are emitted.
*/
public class msg_param_request_list extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_PARAM_REQUEST_LIST = 21;
	public static final int MAVLINK_MSG_LENGTH = 2;

 	/**
	*System ID
	*/
	public byte target_system; 
 	/**
	*Component ID
	*/
	public byte target_component; 


/**
 * Decode a param_request_list message into this class fields
 *
 * @param payload The message to decode
 */
public static MAVLinkMessage unpack(List<Integer> payload) {
    msg_param_request_list m = new msg_param_request_list();
	//m.target_system = _get_target_system(msg);
	//m.target_component = _get_target_component(msg);
    return m;	

    }
}

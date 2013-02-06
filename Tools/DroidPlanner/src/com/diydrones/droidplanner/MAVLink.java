package com.diydrones.droidplanner;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;

public class MAVLink {

	/**
	 * This is a convenience function which handles the complete MAVLink
	 * parsing. the function will parse one byte at a time and return the
	 * complete packet once it could be successfully decoded. Checksum and other
	 * failures will be silently ignored.
	 * 
	 * @param chan
	 *            ID of the current channel. This allows to parse different
	 *            channels with this function. a channel is not a physical
	 *            message channel like a serial port, but a logic partition of
	 *            the communication streams in this case. COMM_NB is the limit
	 *            for the number of channels on MCU (e.g. ARM7), while
	 *            COMM_NB_HIGH is the limit for the number of channels in
	 *            Linux/Windows
	 * @param c
	 *            The char to barse
	 * 
	 * @param returnMsg
	 *            NULL if no message could be decoded, the message data else
	 * @return 0 if no message could be decoded, 1 else
	 * 
	 *         A typical use scenario of this function call is:
	 * 
	 * @code #include <inttypes.h> // For fixed-width uint8_t type
	 * 
	 *       mavlink_message_t msg; int chan = 0;
	 * 
	 * 
	 *       while(serial.bytesAvailable > 0) { uint8_t byte =
	 *       serial.getNextByte(); if (mavlink_parse_char(chan, byte, &msg)) {
	 *       printf(
	 *       "Received message with ID %d, sequence: %d from component %d of system %d"
	 *       , msg.msgid, msg.seq, msg.compid, msg.sysid); } }
	 * 
	 * 
	 * @endcode
	 */

	enum MAV_states {
		MAVLINK_PARSE_STATE_UNINIT, MAVLINK_PARSE_STATE_IDLE, MAVLINK_PARSE_STATE_GOT_STX, MAVLINK_PARSE_STATE_GOT_LENGTH, MAVLINK_PARSE_STATE_GOT_SEQ, MAVLINK_PARSE_STATE_GOT_SYSID, MAVLINK_PARSE_STATE_GOT_COMPID, MAVLINK_PARSE_STATE_GOT_MSGID, MAVLINK_PARSE_STATE_GOT_CRC1, MAVLINK_PARSE_STATE_GOT_PAYLOAD
	}

	MAV_states state = MAV_states.MAVLINK_PARSE_STATE_UNINIT;

	static boolean msg_received;

	private static int seq;

	private static int len;

	private static int sysid;

	private static int compid;

	private static int msgid;

	private static List<Integer> payload;

	private static int MAVLINK_STX = 254;
	
	private CRC crc;

	public MAVLinkMessage mavlink_parse_char(int c) {
		msg_received = false;
		MAVLinkMessage m = null;

		switch (state) {
		case MAVLINK_PARSE_STATE_UNINIT:
		case MAVLINK_PARSE_STATE_IDLE:
			if (c == MAVLINK_STX) {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_STX:
			if (msg_received) {
				msg_received = false;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
			} else {
				// NOT counting STX, LENGTH, SEQ, SYSID, COMPID, MSGID, CRC1 and
				// CRC2
				len = c;
				payload = new ArrayList<Integer>();
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_LENGTH:
			seq = c;
			state = MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ;
			break;

		case MAVLINK_PARSE_STATE_GOT_SEQ:
			sysid = c;
			state = MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID;
			break;

		case MAVLINK_PARSE_STATE_GOT_SYSID:
			compid = c;
			state = MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID;
			break;

		case MAVLINK_PARSE_STATE_GOT_COMPID:
			msgid = c;
			if (len == 0) {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
			} else {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_MSGID:
			payload.add(c);
			if (payload.size() == len) {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_PAYLOAD:
			generateCRC();
			// Check first checksum byte
			if (c != crc.getLSB()) {
				msg_received = false;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
				if (c == MAVLINK_STX) {
					state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
					crc.start_checksum();
				}
			} else {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_CRC1:
			// Check second checksum byte
			if (c != crc.getMSB()) {
				msg_received = false;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
				if (c == MAVLINK_STX) {
					state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
					crc.start_checksum();
				}
			} else { // Successfully received the message
				try {
					m = unpackMessage(payload);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				msg_received = true;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
			}

			break;

		}

		return m;
	}

	private MAVLinkMessage unpackMessage(List<Integer> payload) {
		switch (msgid) {
		case msg_heartbeat.MAVLINK_MSG_ID_HEARTBEAT:
			Log.d("MAVLink", "HEARTBEAT");
			return msg_heartbeat.unpack(payload);
		case msg_attitude.MAVLINK_MSG_ID_ATTITUDE:
			Log.d("MAVLink", "ATTITUDE");
			return msg_attitude.unpack(payload);
			/*
			 * case msg_gps_raw.MAVLINK_MSG_ID_GPS_RAW: Log.d("MAVLink", "GPS");
			 * return unpackGPS_RAW(); case
			 * msg_sys_status.MAVLINK_MSG_ID_SYS_STATUS: Log.d("MAVLink",
			 * "SYS_STATUS"); break; case
			 * msg_waypoint_current.MAVLINK_MSG_ID_WAYPOINT_CURRENT:
			 * Log.d("MAVLink", "WAYPOINT_CURRENT"); break; case
			 * msg_global_position_int.MAVLINK_MSG_ID_GLOBAL_POSITION_INT:
			 * Log.d("MAVLink", "GLOBAL_POSITION_INT"); break; case
			 * msg_statustext.MAVLINK_MSG_ID_STATUSTEXT: Log.d("MAVLink",
			 * "STATUSTEXT"); break; case msg_vfr_hud.MAVLINK_MSG_ID_VFR_HUD:
			 * Log.d("MAVLink", "VRF_HUD"); break;
			 */
		default:
			Log.d("MAVLink", "UNKNOW MESSAGE - " + msgid);
			return null;
		}
	}

	private void generateCRC(){
		crc = new CRC();
		crc.update_checksum(len);
		crc.update_checksum(seq);
		crc.update_checksum(sysid);
		crc.update_checksum(compid);
		crc.update_checksum(msgid);
		for (Integer data : payload) {
			crc.update_checksum(data);			
		}
		crc.finish_checksum(msgid);
	}
	/*
	 * private MAVLinkMessage unpackGPS_RAW() { msg_gps_raw m = new
	 * msg_gps_raw(); m.usec = getInt64(0); m.fix_type = getInt8(8); m.lat =
	 * getInt32(12); m.lon = getInt32(16); m.alt = getInt32(20); m.eph =
	 * getInt16(24); m.epv = getInt16(26); m.v = getInt16(28); m. =
	 * getInt16(28); return m; }
	 */
}


package com.diydrones.droidplanner;

import java.util.ArrayList;
import java.util.List;

import android.R.array;
import android.R.integer;
import android.util.Log;

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

	private static int parse_error;

	private static int MAVLINK_STX = 254;

	public boolean mavlink_parse_char(int c) {
		msg_received = false;

		switch (state) {
		case MAVLINK_PARSE_STATE_UNINIT:
		case MAVLINK_PARSE_STATE_IDLE:
			if (c == MAVLINK_STX) {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
				CRC.mavlink_start_checksum();
				Log.d("MAVLink", "GOT_STX");
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_STX:
			if (msg_received) {
				// status->buffer_overrun++;
				// status->parse_error++;
				msg_received = false;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
			} else {
				// NOT counting STX, LENGTH, SEQ, SYSID, COMPID, MSGID, CRC1 and
				// CRC2
				len = c;
				Log.d("MAVLink", "LENGHT - " + len);
				payload = new ArrayList<Integer>();
				CRC.mavlink_update_checksum(c);
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_LENGTH;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_LENGTH:
			seq = c;
			Log.d("MAVLink", "SEQ - " + seq);
			CRC.mavlink_update_checksum(c);
			state = MAV_states.MAVLINK_PARSE_STATE_GOT_SEQ;
			break;

		case MAVLINK_PARSE_STATE_GOT_SEQ:
			sysid = c;
			Log.d("MAVLink", "SYSID - " + sysid);
			CRC.mavlink_update_checksum(c);
			state = MAV_states.MAVLINK_PARSE_STATE_GOT_SYSID;
			break;

		case MAVLINK_PARSE_STATE_GOT_SYSID:
			compid = c;
			Log.d("MAVLink", "COMPID - " + compid);
			CRC.mavlink_update_checksum(c);
			state = MAV_states.MAVLINK_PARSE_STATE_GOT_COMPID;
			break;

		case MAVLINK_PARSE_STATE_GOT_COMPID:
			msgid = c;
			Log.d("MAVLink", "MSGID - " + msgid);
			CRC.mavlink_update_checksum(c);
			if (len == 0) {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
			} else {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_MSGID;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_MSGID:
			Log.d("MAVLink", "PAYLOAD - " + c);
			payload.add(c);
			CRC.mavlink_update_checksum(c);
			if (payload.size() == len) {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_PAYLOAD;
				Log.d("MAVLink", "PAYLOAD RECEIVED");
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_PAYLOAD:
			CRC.mavlink_update_checksum(50); // TODO fix this magic byte used for CRC calculation, currently only works for Heartbeat messages
			Log.d("MAVLink", "CHECKSUM A - " + c + " - CK_A - " + CRC.getMSB()
					+ " - CK_B - " + CRC.getLSB());
			// Check first checksum byte
			if (c != CRC.getLSB()) {
				parse_error++;
				msg_received = false;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
				if (c == MAVLINK_STX) {
					state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
					CRC.mavlink_start_checksum();
				}
			} else {
				state = MAV_states.MAVLINK_PARSE_STATE_GOT_CRC1;
			}
			break;

		case MAVLINK_PARSE_STATE_GOT_CRC1:
			Log.d("MAVLink", "CHECKSUM B - " + c + " - CK_B - " + CRC.getMSB());
			// Check second checksum byte
			if (c != CRC.getMSB()) {
				parse_error++;
				msg_received = false;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
				if (c == MAVLINK_STX) {
					state = MAV_states.MAVLINK_PARSE_STATE_GOT_STX;
					CRC.mavlink_start_checksum();
				}
			} else { // Successfully received the message
				Log.d("MAVLink", "MESSAGE RECEIVED");
				msg_received = true;
				state = MAV_states.MAVLINK_PARSE_STATE_IDLE;
			}

			break;

		}

		parse_error = 0;
		return msg_received;
	}

	private static class CRC {

		private static final int CRC_INIT_VALUE = 0xffff;
		private static int CRCvalue;

		/**
		 * Accumulate the X.25 CRC by adding one char at a time.
		 * 
		 * The checksum function adds the hash of one char at a time to the 16
		 * bit checksum (uint16_t).
		 * 
		 * @param data
		 *            new char to hash
		 * @param crcAccum
		 *            the already accumulated checksum
		 **/
		private static void mavlink_update_checksum(int data) {
			// TODO Check this function
			int tmp;
			tmp = data ^ (CRCvalue & 0xff);
			tmp ^= (tmp << 4) & 0xff;
			CRCvalue = ((CRCvalue >> 8) & 0xff) ^ (tmp << 8) ^ (tmp << 3) ^ ((tmp >> 4)&0xf);
		}

		/**
		 * Initialize the buffer for the X.25 CRC
		 * 
		 */
		private static void mavlink_start_checksum() {
			// TODO Check this function
			CRCvalue = CRC_INIT_VALUE;
		}

		public static int getMSB() {
			return ((CRCvalue >> 8) & 0xff);
		}

		public static int getLSB() {
			return (CRCvalue & 0xff);
		}

	}
}

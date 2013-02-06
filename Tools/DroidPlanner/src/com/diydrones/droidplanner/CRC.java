package com.diydrones.droidplanner;

/**
 * X.25 CRC calculation for MAVlink messages. The checksum must be initialized,
 * updated with witch field of the message, and then finished with the message
 * id.
 * 
 */
class CRC {
	private final int[] MAVLINK_MESSAGE_CRCS = { 50, 124, 137, 0, 237,
			217, 104, 119, 0, 0, 0, 89, 0, 0, 0, 0, 0, 0, 0, 0, 214, 159, 220,
			168, 24, 23, 170, 144, 67, 115, 39, 246, 185, 104, 237, 244, 222,
			212, 9, 254, 230, 28, 28, 132, 221, 232, 11, 153, 41, 39, 214, 223,
			141, 33, 15, 3, 100, 24, 239, 238, 0, 0, 183, 0, 130, 0, 148, 21,
			0, 52, 124, 0, 0, 0, 20, 0, 152, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 183, 63, 54, 0, 0, 0, 0, 0, 0, 0, 19, 102, 158, 208, 56, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			134, 219, 208, 188, 84, 22, 19, 21, 134, 0, 78, 68, 189, 127, 42,
			21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 204, 49, 170,
			44, 83, 46, 247 };
	private static final int CRC_INIT_VALUE = 0xffff;
	private int CRCvalue;
	
	

	/**
	 * Accumulate the X.25 CRC by adding one char at a time.
	 * 
	 * The checksum function adds the hash of one char at a time to the 16 bit
	 * checksum (uint16_t).
	 * 
	 * @param data
	 *            new char to hash
	 * @param crcAccum
	 *            the already accumulated checksum
	 **/
	public  void update_checksum(int data) {
		int tmp;
		tmp = data ^ (CRCvalue & 0xff);
		tmp ^= (tmp << 4) & 0xff;
		CRCvalue = ((CRCvalue >> 8) & 0xff) ^ (tmp << 8) ^ (tmp << 3)
				^ ((tmp >> 4) & 0xf);
	}

	/**
	 * Finish the CRC calculation of a message, by running the CRC with the
	 * Magic Byte. This Magic byte has been defined in MAVlink v1.0.
	 * 
	 * @param msgid
	 *            The message id number
	 */
	public  void finish_checksum(int msgid) {
		update_checksum(MAVLINK_MESSAGE_CRCS[msgid]);
	}

	/**
	 * Initialize the buffer for the X.25 CRC
	 * 
	 */
	public void start_checksum() {
		CRCvalue = CRC_INIT_VALUE;
	}

	public int getMSB() {
		return ((CRCvalue >> 8) & 0xff);
	}

	public int getLSB() {
		return (CRCvalue & 0xff);
	}

	public CRC() {
		start_checksum();
	}

}
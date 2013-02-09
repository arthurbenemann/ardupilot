// MESSAGE GPS_RAW_INT PACKING
package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.MAVLinkPacket;
import android.util.Log;

/**
* The global position, as returned by the Global Positioning System (GPS). This is
                NOT the global position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate. Coordinate frame is right-handed, Z-axis up (GPS frame).
*/
public class msg_gps_raw_int extends MAVLinkMessage{

	public static final int MAVLINK_MSG_ID_GPS_RAW_INT = 24;
	public static final int MAVLINK_MSG_LENGTH = 30;

 	/**
	*Timestamp (microseconds since UNIX epoch or microseconds since system boot)
	*/
	public long time_usec; 
 	/**
	*Latitude in 1E7 degrees
	*/
	public int lat; 
 	/**
	*Longitude in 1E7 degrees
	*/
	public int lon; 
 	/**
	*Altitude in 1E3 meters (millimeters) above MSL
	*/
	public int alt; 
 	/**
	*GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535
	*/
	public short eph; 
 	/**
	*GPS VDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535
	*/
	public short epv; 
 	/**
	*GPS ground speed (m/s * 100). If unknown, set to: 65535
	*/
	public short vel; 
 	/**
	*Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 65535
	*/
	public short cog; 
 	/**
	*0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix.
	*/
	public byte fix_type; 
 	/**
	*Number of satellites visible. If unknown, set to 255
	*/
	public byte satellites_visible; 

	/**
	 * Generates the payload for a mavlink message for a message of this type
	 * @return
	 */
	public MAVLinkPacket pack(){
		MAVLinkPacket packet = new MAVLinkPacket();
		packet.msgid = MAVLINK_MSG_ID_GPS_RAW_INT;
		packet.payload.putLong(time_usec);
		packet.payload.putInt(lat);
		packet.payload.putInt(lon);
		packet.payload.putInt(alt);
		packet.payload.putShort(eph);
		packet.payload.putShort(epv);
		packet.payload.putShort(vel);
		packet.payload.putShort(cog);
		packet.payload.putByte(fix_type);
		packet.payload.putByte(satellites_visible);
		return packet;		
	}

    /**
     * Decode a gps_raw_int message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
	    time_usec = payload.getLong();
	    lat = payload.getInt();
	    lon = payload.getInt();
	    alt = payload.getInt();
	    eph = payload.getShort();
	    epv = payload.getShort();
	    vel = payload.getShort();
	    cog = payload.getShort();
	    fix_type = payload.getByte();
	    satellites_visible = payload.getByte();    
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     * 
     */
    public msg_gps_raw_int(MAVLinkPayload payload){
        msgid = MAVLINK_MSG_ID_GPS_RAW_INT;
        unpack(payload);
        Log.d("MAVLink", "GPS_RAW_INT");
        //Log.d("MAVLINK_MSG_ID_GPS_RAW_INT", toString());
    }

    /**
     * Returns a string with the MSG name and data
     */
    public String toString(){
    	return "MAVLINK_MSG_ID_GPS_RAW_INT -"+" time_usec:"+time_usec+" lat:"+lat+" lon:"+lon+" alt:"+alt+" eph:"+eph+" epv:"+epv+" vel:"+vel+" cog:"+cog+" fix_type:"+fix_type+" satellites_visible:"+satellites_visible+"";
    }
}

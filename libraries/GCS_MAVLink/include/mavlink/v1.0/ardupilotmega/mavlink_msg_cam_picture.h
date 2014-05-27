// MESSAGE CAM_PICTURE PACKING

#define MAVLINK_MSG_ID_CAM_PICTURE 179

typedef struct __mavlink_cam_picture_t
{
 uint32_t time_boot_ms; ///< Timestamp (milliseconds since system boot)
 float roll; ///< Roll angle (rad)
 float pitch; ///< Pitch angle (rad)
 float yaw; ///< Yaw angle (rad)
 int32_t lat; ///< Latitude, expressed as * 1E7
 int32_t lon; ///< Longitude, expressed as * 1E7
 int32_t alt; ///< Altitude in meters, expressed as * 1000 (millimeters), above MSL
} mavlink_cam_picture_t;

#define MAVLINK_MSG_ID_CAM_PICTURE_LEN 28
#define MAVLINK_MSG_ID_179_LEN 28

#define MAVLINK_MSG_ID_CAM_PICTURE_CRC 150
#define MAVLINK_MSG_ID_179_CRC 150



#define MAVLINK_MESSAGE_INFO_CAM_PICTURE { \
	"CAM_PICTURE", \
	7, \
	{  { "time_boot_ms", NULL, MAVLINK_TYPE_UINT32_T, 0, 0, offsetof(mavlink_cam_picture_t, time_boot_ms) }, \
         { "roll", NULL, MAVLINK_TYPE_FLOAT, 0, 4, offsetof(mavlink_cam_picture_t, roll) }, \
         { "pitch", NULL, MAVLINK_TYPE_FLOAT, 0, 8, offsetof(mavlink_cam_picture_t, pitch) }, \
         { "yaw", NULL, MAVLINK_TYPE_FLOAT, 0, 12, offsetof(mavlink_cam_picture_t, yaw) }, \
         { "lat", NULL, MAVLINK_TYPE_INT32_T, 0, 16, offsetof(mavlink_cam_picture_t, lat) }, \
         { "lon", NULL, MAVLINK_TYPE_INT32_T, 0, 20, offsetof(mavlink_cam_picture_t, lon) }, \
         { "alt", NULL, MAVLINK_TYPE_INT32_T, 0, 24, offsetof(mavlink_cam_picture_t, alt) }, \
         } \
}


/**
 * @brief Pack a cam_picture message
 * @param system_id ID of this system
 * @param component_id ID of this component (e.g. 200 for IMU)
 * @param msg The MAVLink message to compress the data into
 *
 * @param time_boot_ms Timestamp (milliseconds since system boot)
 * @param roll Roll angle (rad)
 * @param pitch Pitch angle (rad)
 * @param yaw Yaw angle (rad)
 * @param lat Latitude, expressed as * 1E7
 * @param lon Longitude, expressed as * 1E7
 * @param alt Altitude in meters, expressed as * 1000 (millimeters), above MSL
 * @return length of the message in bytes (excluding serial stream start sign)
 */
static inline uint16_t mavlink_msg_cam_picture_pack(uint8_t system_id, uint8_t component_id, mavlink_message_t* msg,
						       uint32_t time_boot_ms, float roll, float pitch, float yaw, int32_t lat, int32_t lon, int32_t alt)
{
#if MAVLINK_NEED_BYTE_SWAP || !MAVLINK_ALIGNED_FIELDS
	char buf[MAVLINK_MSG_ID_CAM_PICTURE_LEN];
	_mav_put_uint32_t(buf, 0, time_boot_ms);
	_mav_put_float(buf, 4, roll);
	_mav_put_float(buf, 8, pitch);
	_mav_put_float(buf, 12, yaw);
	_mav_put_int32_t(buf, 16, lat);
	_mav_put_int32_t(buf, 20, lon);
	_mav_put_int32_t(buf, 24, alt);

        memcpy(_MAV_PAYLOAD_NON_CONST(msg), buf, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#else
	mavlink_cam_picture_t packet;
	packet.time_boot_ms = time_boot_ms;
	packet.roll = roll;
	packet.pitch = pitch;
	packet.yaw = yaw;
	packet.lat = lat;
	packet.lon = lon;
	packet.alt = alt;

        memcpy(_MAV_PAYLOAD_NON_CONST(msg), &packet, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif

	msg->msgid = MAVLINK_MSG_ID_CAM_PICTURE;
#if MAVLINK_CRC_EXTRA
    return mavlink_finalize_message(msg, system_id, component_id, MAVLINK_MSG_ID_CAM_PICTURE_LEN, MAVLINK_MSG_ID_CAM_PICTURE_CRC);
#else
    return mavlink_finalize_message(msg, system_id, component_id, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
}

/**
 * @brief Pack a cam_picture message on a channel
 * @param system_id ID of this system
 * @param component_id ID of this component (e.g. 200 for IMU)
 * @param chan The MAVLink channel this message will be sent over
 * @param msg The MAVLink message to compress the data into
 * @param time_boot_ms Timestamp (milliseconds since system boot)
 * @param roll Roll angle (rad)
 * @param pitch Pitch angle (rad)
 * @param yaw Yaw angle (rad)
 * @param lat Latitude, expressed as * 1E7
 * @param lon Longitude, expressed as * 1E7
 * @param alt Altitude in meters, expressed as * 1000 (millimeters), above MSL
 * @return length of the message in bytes (excluding serial stream start sign)
 */
static inline uint16_t mavlink_msg_cam_picture_pack_chan(uint8_t system_id, uint8_t component_id, uint8_t chan,
							   mavlink_message_t* msg,
						           uint32_t time_boot_ms,float roll,float pitch,float yaw,int32_t lat,int32_t lon,int32_t alt)
{
#if MAVLINK_NEED_BYTE_SWAP || !MAVLINK_ALIGNED_FIELDS
	char buf[MAVLINK_MSG_ID_CAM_PICTURE_LEN];
	_mav_put_uint32_t(buf, 0, time_boot_ms);
	_mav_put_float(buf, 4, roll);
	_mav_put_float(buf, 8, pitch);
	_mav_put_float(buf, 12, yaw);
	_mav_put_int32_t(buf, 16, lat);
	_mav_put_int32_t(buf, 20, lon);
	_mav_put_int32_t(buf, 24, alt);

        memcpy(_MAV_PAYLOAD_NON_CONST(msg), buf, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#else
	mavlink_cam_picture_t packet;
	packet.time_boot_ms = time_boot_ms;
	packet.roll = roll;
	packet.pitch = pitch;
	packet.yaw = yaw;
	packet.lat = lat;
	packet.lon = lon;
	packet.alt = alt;

        memcpy(_MAV_PAYLOAD_NON_CONST(msg), &packet, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif

	msg->msgid = MAVLINK_MSG_ID_CAM_PICTURE;
#if MAVLINK_CRC_EXTRA
    return mavlink_finalize_message_chan(msg, system_id, component_id, chan, MAVLINK_MSG_ID_CAM_PICTURE_LEN, MAVLINK_MSG_ID_CAM_PICTURE_CRC);
#else
    return mavlink_finalize_message_chan(msg, system_id, component_id, chan, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
}

/**
 * @brief Encode a cam_picture struct
 *
 * @param system_id ID of this system
 * @param component_id ID of this component (e.g. 200 for IMU)
 * @param msg The MAVLink message to compress the data into
 * @param cam_picture C-struct to read the message contents from
 */
static inline uint16_t mavlink_msg_cam_picture_encode(uint8_t system_id, uint8_t component_id, mavlink_message_t* msg, const mavlink_cam_picture_t* cam_picture)
{
	return mavlink_msg_cam_picture_pack(system_id, component_id, msg, cam_picture->time_boot_ms, cam_picture->roll, cam_picture->pitch, cam_picture->yaw, cam_picture->lat, cam_picture->lon, cam_picture->alt);
}

/**
 * @brief Encode a cam_picture struct on a channel
 *
 * @param system_id ID of this system
 * @param component_id ID of this component (e.g. 200 for IMU)
 * @param chan The MAVLink channel this message will be sent over
 * @param msg The MAVLink message to compress the data into
 * @param cam_picture C-struct to read the message contents from
 */
static inline uint16_t mavlink_msg_cam_picture_encode_chan(uint8_t system_id, uint8_t component_id, uint8_t chan, mavlink_message_t* msg, const mavlink_cam_picture_t* cam_picture)
{
	return mavlink_msg_cam_picture_pack_chan(system_id, component_id, chan, msg, cam_picture->time_boot_ms, cam_picture->roll, cam_picture->pitch, cam_picture->yaw, cam_picture->lat, cam_picture->lon, cam_picture->alt);
}

/**
 * @brief Send a cam_picture message
 * @param chan MAVLink channel to send the message
 *
 * @param time_boot_ms Timestamp (milliseconds since system boot)
 * @param roll Roll angle (rad)
 * @param pitch Pitch angle (rad)
 * @param yaw Yaw angle (rad)
 * @param lat Latitude, expressed as * 1E7
 * @param lon Longitude, expressed as * 1E7
 * @param alt Altitude in meters, expressed as * 1000 (millimeters), above MSL
 */
#ifdef MAVLINK_USE_CONVENIENCE_FUNCTIONS

static inline void mavlink_msg_cam_picture_send(mavlink_channel_t chan, uint32_t time_boot_ms, float roll, float pitch, float yaw, int32_t lat, int32_t lon, int32_t alt)
{
#if MAVLINK_NEED_BYTE_SWAP || !MAVLINK_ALIGNED_FIELDS
	char buf[MAVLINK_MSG_ID_CAM_PICTURE_LEN];
	_mav_put_uint32_t(buf, 0, time_boot_ms);
	_mav_put_float(buf, 4, roll);
	_mav_put_float(buf, 8, pitch);
	_mav_put_float(buf, 12, yaw);
	_mav_put_int32_t(buf, 16, lat);
	_mav_put_int32_t(buf, 20, lon);
	_mav_put_int32_t(buf, 24, alt);

#if MAVLINK_CRC_EXTRA
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, buf, MAVLINK_MSG_ID_CAM_PICTURE_LEN, MAVLINK_MSG_ID_CAM_PICTURE_CRC);
#else
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, buf, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
#else
	mavlink_cam_picture_t packet;
	packet.time_boot_ms = time_boot_ms;
	packet.roll = roll;
	packet.pitch = pitch;
	packet.yaw = yaw;
	packet.lat = lat;
	packet.lon = lon;
	packet.alt = alt;

#if MAVLINK_CRC_EXTRA
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, (const char *)&packet, MAVLINK_MSG_ID_CAM_PICTURE_LEN, MAVLINK_MSG_ID_CAM_PICTURE_CRC);
#else
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, (const char *)&packet, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
#endif
}

#if MAVLINK_MSG_ID_CAM_PICTURE_LEN <= MAVLINK_MAX_PAYLOAD_LEN
/*
  This varient of _send() can be used to save stack space by re-using
  memory from the receive buffer.  The caller provides a
  mavlink_message_t which is the size of a full mavlink message. This
  is usually the receive buffer for the channel, and allows a reply to an
  incoming message with minimum stack space usage.
 */
static inline void mavlink_msg_cam_picture_send_buf(mavlink_message_t *msgbuf, mavlink_channel_t chan,  uint32_t time_boot_ms, float roll, float pitch, float yaw, int32_t lat, int32_t lon, int32_t alt)
{
#if MAVLINK_NEED_BYTE_SWAP || !MAVLINK_ALIGNED_FIELDS
	char *buf = (char *)msgbuf;
	_mav_put_uint32_t(buf, 0, time_boot_ms);
	_mav_put_float(buf, 4, roll);
	_mav_put_float(buf, 8, pitch);
	_mav_put_float(buf, 12, yaw);
	_mav_put_int32_t(buf, 16, lat);
	_mav_put_int32_t(buf, 20, lon);
	_mav_put_int32_t(buf, 24, alt);

#if MAVLINK_CRC_EXTRA
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, buf, MAVLINK_MSG_ID_CAM_PICTURE_LEN, MAVLINK_MSG_ID_CAM_PICTURE_CRC);
#else
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, buf, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
#else
	mavlink_cam_picture_t *packet = (mavlink_cam_picture_t *)msgbuf;
	packet->time_boot_ms = time_boot_ms;
	packet->roll = roll;
	packet->pitch = pitch;
	packet->yaw = yaw;
	packet->lat = lat;
	packet->lon = lon;
	packet->alt = alt;

#if MAVLINK_CRC_EXTRA
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, (const char *)packet, MAVLINK_MSG_ID_CAM_PICTURE_LEN, MAVLINK_MSG_ID_CAM_PICTURE_CRC);
#else
    _mav_finalize_message_chan_send(chan, MAVLINK_MSG_ID_CAM_PICTURE, (const char *)packet, MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
#endif
}
#endif

#endif

// MESSAGE CAM_PICTURE UNPACKING


/**
 * @brief Get field time_boot_ms from cam_picture message
 *
 * @return Timestamp (milliseconds since system boot)
 */
static inline uint32_t mavlink_msg_cam_picture_get_time_boot_ms(const mavlink_message_t* msg)
{
	return _MAV_RETURN_uint32_t(msg,  0);
}

/**
 * @brief Get field roll from cam_picture message
 *
 * @return Roll angle (rad)
 */
static inline float mavlink_msg_cam_picture_get_roll(const mavlink_message_t* msg)
{
	return _MAV_RETURN_float(msg,  4);
}

/**
 * @brief Get field pitch from cam_picture message
 *
 * @return Pitch angle (rad)
 */
static inline float mavlink_msg_cam_picture_get_pitch(const mavlink_message_t* msg)
{
	return _MAV_RETURN_float(msg,  8);
}

/**
 * @brief Get field yaw from cam_picture message
 *
 * @return Yaw angle (rad)
 */
static inline float mavlink_msg_cam_picture_get_yaw(const mavlink_message_t* msg)
{
	return _MAV_RETURN_float(msg,  12);
}

/**
 * @brief Get field lat from cam_picture message
 *
 * @return Latitude, expressed as * 1E7
 */
static inline int32_t mavlink_msg_cam_picture_get_lat(const mavlink_message_t* msg)
{
	return _MAV_RETURN_int32_t(msg,  16);
}

/**
 * @brief Get field lon from cam_picture message
 *
 * @return Longitude, expressed as * 1E7
 */
static inline int32_t mavlink_msg_cam_picture_get_lon(const mavlink_message_t* msg)
{
	return _MAV_RETURN_int32_t(msg,  20);
}

/**
 * @brief Get field alt from cam_picture message
 *
 * @return Altitude in meters, expressed as * 1000 (millimeters), above MSL
 */
static inline int32_t mavlink_msg_cam_picture_get_alt(const mavlink_message_t* msg)
{
	return _MAV_RETURN_int32_t(msg,  24);
}

/**
 * @brief Decode a cam_picture message into a struct
 *
 * @param msg The message to decode
 * @param cam_picture C-struct to decode the message contents into
 */
static inline void mavlink_msg_cam_picture_decode(const mavlink_message_t* msg, mavlink_cam_picture_t* cam_picture)
{
#if MAVLINK_NEED_BYTE_SWAP
	cam_picture->time_boot_ms = mavlink_msg_cam_picture_get_time_boot_ms(msg);
	cam_picture->roll = mavlink_msg_cam_picture_get_roll(msg);
	cam_picture->pitch = mavlink_msg_cam_picture_get_pitch(msg);
	cam_picture->yaw = mavlink_msg_cam_picture_get_yaw(msg);
	cam_picture->lat = mavlink_msg_cam_picture_get_lat(msg);
	cam_picture->lon = mavlink_msg_cam_picture_get_lon(msg);
	cam_picture->alt = mavlink_msg_cam_picture_get_alt(msg);
#else
	memcpy(cam_picture, _MAV_PAYLOAD(msg), MAVLINK_MSG_ID_CAM_PICTURE_LEN);
#endif
}

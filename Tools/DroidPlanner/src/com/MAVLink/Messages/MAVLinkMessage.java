
package com.MAVLink.Messages;

import java.util.List;
import android.util.Log;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.MAVLink.Messages.ardupilotmega.msg_system_time;
import com.MAVLink.Messages.ardupilotmega.msg_ping;
import com.MAVLink.Messages.ardupilotmega.msg_change_operator_control;
import com.MAVLink.Messages.ardupilotmega.msg_change_operator_control_ack;
import com.MAVLink.Messages.ardupilotmega.msg_auth_key;
import com.MAVLink.Messages.ardupilotmega.msg_set_mode;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_read;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_param_value;
import com.MAVLink.Messages.ardupilotmega.msg_param_set;
import com.MAVLink.Messages.ardupilotmega.msg_gps_raw_int;
import com.MAVLink.Messages.ardupilotmega.msg_gps_status;
import com.MAVLink.Messages.ardupilotmega.msg_scaled_imu;
import com.MAVLink.Messages.ardupilotmega.msg_raw_imu;
import com.MAVLink.Messages.ardupilotmega.msg_raw_pressure;
import com.MAVLink.Messages.ardupilotmega.msg_scaled_pressure;
import com.MAVLink.Messages.ardupilotmega.msg_attitude;
import com.MAVLink.Messages.ardupilotmega.msg_attitude_quaternion;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_ned;
import com.MAVLink.Messages.ardupilotmega.msg_global_position_int;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels_scaled;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels_raw;
import com.MAVLink.Messages.ardupilotmega.msg_servo_output_raw;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_partial_list;
import com.MAVLink.Messages.ardupilotmega.msg_mission_write_partial_list;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request;
import com.MAVLink.Messages.ardupilotmega.msg_mission_set_current;
import com.MAVLink.Messages.ardupilotmega.msg_mission_current;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_list;
import com.MAVLink.Messages.ardupilotmega.msg_mission_count;
import com.MAVLink.Messages.ardupilotmega.msg_mission_clear_all;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item_reached;
import com.MAVLink.Messages.ardupilotmega.msg_mission_ack;
import com.MAVLink.Messages.ardupilotmega.msg_set_gps_global_origin;
import com.MAVLink.Messages.ardupilotmega.msg_gps_global_origin;
import com.MAVLink.Messages.ardupilotmega.msg_set_local_position_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_global_position_setpoint_int;
import com.MAVLink.Messages.ardupilotmega.msg_set_global_position_setpoint_int;
import com.MAVLink.Messages.ardupilotmega.msg_safety_set_allowed_area;
import com.MAVLink.Messages.ardupilotmega.msg_safety_allowed_area;
import com.MAVLink.Messages.ardupilotmega.msg_set_roll_pitch_yaw_thrust;
import com.MAVLink.Messages.ardupilotmega.msg_set_roll_pitch_yaw_speed_thrust;
import com.MAVLink.Messages.ardupilotmega.msg_roll_pitch_yaw_thrust_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_roll_pitch_yaw_speed_thrust_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_set_quad_motors_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_set_quad_swarm_roll_pitch_yaw_thrust;
import com.MAVLink.Messages.ardupilotmega.msg_nav_controller_output;
import com.MAVLink.Messages.ardupilotmega.msg_set_quad_swarm_led_roll_pitch_yaw_thrust;
import com.MAVLink.Messages.ardupilotmega.msg_state_correction;
import com.MAVLink.Messages.ardupilotmega.msg_request_data_stream;
import com.MAVLink.Messages.ardupilotmega.msg_data_stream;
import com.MAVLink.Messages.ardupilotmega.msg_manual_control;
import com.MAVLink.Messages.ardupilotmega.msg_rc_channels_override;
import com.MAVLink.Messages.ardupilotmega.msg_vfr_hud;
import com.MAVLink.Messages.ardupilotmega.msg_command_long;
import com.MAVLink.Messages.ardupilotmega.msg_command_ack;
import com.MAVLink.Messages.ardupilotmega.msg_roll_pitch_yaw_rates_thrust_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_manual_setpoint;
import com.MAVLink.Messages.ardupilotmega.msg_local_position_ned_system_global_offset;
import com.MAVLink.Messages.ardupilotmega.msg_hil_state;
import com.MAVLink.Messages.ardupilotmega.msg_hil_controls;
import com.MAVLink.Messages.ardupilotmega.msg_hil_rc_inputs_raw;
import com.MAVLink.Messages.ardupilotmega.msg_optical_flow;
import com.MAVLink.Messages.ardupilotmega.msg_global_vision_position_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_vision_position_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_vision_speed_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_vicon_position_estimate;
import com.MAVLink.Messages.ardupilotmega.msg_highres_imu;
import com.MAVLink.Messages.ardupilotmega.msg_omnidirectional_flow;
import com.MAVLink.Messages.ardupilotmega.msg_file_transfer_start;
import com.MAVLink.Messages.ardupilotmega.msg_file_transfer_dir_list;
import com.MAVLink.Messages.ardupilotmega.msg_file_transfer_res;
import com.MAVLink.Messages.ardupilotmega.msg_battery_status;
import com.MAVLink.Messages.ardupilotmega.msg_setpoint_8dof;
import com.MAVLink.Messages.ardupilotmega.msg_setpoint_6dof;
import com.MAVLink.Messages.ardupilotmega.msg_memory_vect;
import com.MAVLink.Messages.ardupilotmega.msg_debug_vect;
import com.MAVLink.Messages.ardupilotmega.msg_named_value_float;
import com.MAVLink.Messages.ardupilotmega.msg_named_value_int;
import com.MAVLink.Messages.ardupilotmega.msg_statustext;
import com.MAVLink.Messages.ardupilotmega.msg_debug;

public class MAVLinkMessage {
	/**
	 *  Simply a common interface for all MAVLink Messages
	 */
	
	public int messageType = -1;	
	public int seq;
	public int len;
	public  int sysid;
	public int compid;
	public int msgid;
	public List<Integer> payload;	
	public CRC crc;	
	
	/*
	private Integer getInt64(int i){
		return payload.get(i) << 32  | (payload.get(i+4) & 0xFFFFFFFF);
	}*/
	
	public static Integer getInt32(int i,List<Integer> payload){
		 return payload.get(i+3) << 24 | (payload.get(i+2) & 0xFF) << 16 | payload.get(i+1) & 0xFF << 8 | (payload.get(i) & 0xFF);
	}	

	public static Integer getInt8(int i,List<Integer> payload){
		 return payload.get(i);
	}

	public static float getFloat(int i,List<Integer> payload) {
		return Float.intBitsToFloat(getInt32(i,payload));
	}
	
	public void generateCRC(){
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
	
	public boolean payloadIsFilled() {
		return (payload.size() == len);
	}
	
	public MAVLinkMessage unpackMessage() {
		switch (msgid) {
		case msg_heartbeat.MAVLINK_MSG_ID_HEARTBEAT:
			Log.d("MAVLink", "HEARTBEAT");
			return msg_heartbeat.unpack(payload);
		case msg_sys_status.MAVLINK_MSG_ID_SYS_STATUS:
			Log.d("MAVLink", "SYS_STATUS");
			return msg_sys_status.unpack(payload);
		case msg_system_time.MAVLINK_MSG_ID_SYSTEM_TIME:
			Log.d("MAVLink", "SYSTEM_TIME");
			return msg_system_time.unpack(payload);
		case msg_ping.MAVLINK_MSG_ID_PING:
			Log.d("MAVLink", "PING");
			return msg_ping.unpack(payload);
		case msg_change_operator_control.MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL:
			Log.d("MAVLink", "CHANGE_OPERATOR_CONTROL");
			return msg_change_operator_control.unpack(payload);
		case msg_change_operator_control_ack.MAVLINK_MSG_ID_CHANGE_OPERATOR_CONTROL_ACK:
			Log.d("MAVLink", "CHANGE_OPERATOR_CONTROL_ACK");
			return msg_change_operator_control_ack.unpack(payload);
		case msg_auth_key.MAVLINK_MSG_ID_AUTH_KEY:
			Log.d("MAVLink", "AUTH_KEY");
			return msg_auth_key.unpack(payload);
		case msg_set_mode.MAVLINK_MSG_ID_SET_MODE:
			Log.d("MAVLink", "SET_MODE");
			return msg_set_mode.unpack(payload);
		case msg_param_request_read.MAVLINK_MSG_ID_PARAM_REQUEST_READ:
			Log.d("MAVLink", "PARAM_REQUEST_READ");
			return msg_param_request_read.unpack(payload);
		case msg_param_request_list.MAVLINK_MSG_ID_PARAM_REQUEST_LIST:
			Log.d("MAVLink", "PARAM_REQUEST_LIST");
			return msg_param_request_list.unpack(payload);
		case msg_param_value.MAVLINK_MSG_ID_PARAM_VALUE:
			Log.d("MAVLink", "PARAM_VALUE");
			return msg_param_value.unpack(payload);
		case msg_param_set.MAVLINK_MSG_ID_PARAM_SET:
			Log.d("MAVLink", "PARAM_SET");
			return msg_param_set.unpack(payload);
		case msg_gps_raw_int.MAVLINK_MSG_ID_GPS_RAW_INT:
			Log.d("MAVLink", "GPS_RAW_INT");
			return msg_gps_raw_int.unpack(payload);
		case msg_gps_status.MAVLINK_MSG_ID_GPS_STATUS:
			Log.d("MAVLink", "GPS_STATUS");
			return msg_gps_status.unpack(payload);
		case msg_scaled_imu.MAVLINK_MSG_ID_SCALED_IMU:
			Log.d("MAVLink", "SCALED_IMU");
			return msg_scaled_imu.unpack(payload);
		case msg_raw_imu.MAVLINK_MSG_ID_RAW_IMU:
			Log.d("MAVLink", "RAW_IMU");
			return msg_raw_imu.unpack(payload);
		case msg_raw_pressure.MAVLINK_MSG_ID_RAW_PRESSURE:
			Log.d("MAVLink", "RAW_PRESSURE");
			return msg_raw_pressure.unpack(payload);
		case msg_scaled_pressure.MAVLINK_MSG_ID_SCALED_PRESSURE:
			Log.d("MAVLink", "SCALED_PRESSURE");
			return msg_scaled_pressure.unpack(payload);
		case msg_attitude.MAVLINK_MSG_ID_ATTITUDE:
			Log.d("MAVLink", "ATTITUDE");
			return msg_attitude.unpack(payload);
		case msg_attitude_quaternion.MAVLINK_MSG_ID_ATTITUDE_QUATERNION:
			Log.d("MAVLink", "ATTITUDE_QUATERNION");
			return msg_attitude_quaternion.unpack(payload);
		case msg_local_position_ned.MAVLINK_MSG_ID_LOCAL_POSITION_NED:
			Log.d("MAVLink", "LOCAL_POSITION_NED");
			return msg_local_position_ned.unpack(payload);
		case msg_global_position_int.MAVLINK_MSG_ID_GLOBAL_POSITION_INT:
			Log.d("MAVLink", "GLOBAL_POSITION_INT");
			return msg_global_position_int.unpack(payload);
		case msg_rc_channels_scaled.MAVLINK_MSG_ID_RC_CHANNELS_SCALED:
			Log.d("MAVLink", "RC_CHANNELS_SCALED");
			return msg_rc_channels_scaled.unpack(payload);
		case msg_rc_channels_raw.MAVLINK_MSG_ID_RC_CHANNELS_RAW:
			Log.d("MAVLink", "RC_CHANNELS_RAW");
			return msg_rc_channels_raw.unpack(payload);
		case msg_servo_output_raw.MAVLINK_MSG_ID_SERVO_OUTPUT_RAW:
			Log.d("MAVLink", "SERVO_OUTPUT_RAW");
			return msg_servo_output_raw.unpack(payload);
		case msg_mission_request_partial_list.MAVLINK_MSG_ID_MISSION_REQUEST_PARTIAL_LIST:
			Log.d("MAVLink", "MISSION_REQUEST_PARTIAL_LIST");
			return msg_mission_request_partial_list.unpack(payload);
		case msg_mission_write_partial_list.MAVLINK_MSG_ID_MISSION_WRITE_PARTIAL_LIST:
			Log.d("MAVLink", "MISSION_WRITE_PARTIAL_LIST");
			return msg_mission_write_partial_list.unpack(payload);
		case msg_mission_item.MAVLINK_MSG_ID_MISSION_ITEM:
			Log.d("MAVLink", "MISSION_ITEM");
			return msg_mission_item.unpack(payload);
		case msg_mission_request.MAVLINK_MSG_ID_MISSION_REQUEST:
			Log.d("MAVLink", "MISSION_REQUEST");
			return msg_mission_request.unpack(payload);
		case msg_mission_set_current.MAVLINK_MSG_ID_MISSION_SET_CURRENT:
			Log.d("MAVLink", "MISSION_SET_CURRENT");
			return msg_mission_set_current.unpack(payload);
		case msg_mission_current.MAVLINK_MSG_ID_MISSION_CURRENT:
			Log.d("MAVLink", "MISSION_CURRENT");
			return msg_mission_current.unpack(payload);
		case msg_mission_request_list.MAVLINK_MSG_ID_MISSION_REQUEST_LIST:
			Log.d("MAVLink", "MISSION_REQUEST_LIST");
			return msg_mission_request_list.unpack(payload);
		case msg_mission_count.MAVLINK_MSG_ID_MISSION_COUNT:
			Log.d("MAVLink", "MISSION_COUNT");
			return msg_mission_count.unpack(payload);
		case msg_mission_clear_all.MAVLINK_MSG_ID_MISSION_CLEAR_ALL:
			Log.d("MAVLink", "MISSION_CLEAR_ALL");
			return msg_mission_clear_all.unpack(payload);
		case msg_mission_item_reached.MAVLINK_MSG_ID_MISSION_ITEM_REACHED:
			Log.d("MAVLink", "MISSION_ITEM_REACHED");
			return msg_mission_item_reached.unpack(payload);
		case msg_mission_ack.MAVLINK_MSG_ID_MISSION_ACK:
			Log.d("MAVLink", "MISSION_ACK");
			return msg_mission_ack.unpack(payload);
		case msg_set_gps_global_origin.MAVLINK_MSG_ID_SET_GPS_GLOBAL_ORIGIN:
			Log.d("MAVLink", "SET_GPS_GLOBAL_ORIGIN");
			return msg_set_gps_global_origin.unpack(payload);
		case msg_gps_global_origin.MAVLINK_MSG_ID_GPS_GLOBAL_ORIGIN:
			Log.d("MAVLink", "GPS_GLOBAL_ORIGIN");
			return msg_gps_global_origin.unpack(payload);
		case msg_set_local_position_setpoint.MAVLINK_MSG_ID_SET_LOCAL_POSITION_SETPOINT:
			Log.d("MAVLink", "SET_LOCAL_POSITION_SETPOINT");
			return msg_set_local_position_setpoint.unpack(payload);
		case msg_local_position_setpoint.MAVLINK_MSG_ID_LOCAL_POSITION_SETPOINT:
			Log.d("MAVLink", "LOCAL_POSITION_SETPOINT");
			return msg_local_position_setpoint.unpack(payload);
		case msg_global_position_setpoint_int.MAVLINK_MSG_ID_GLOBAL_POSITION_SETPOINT_INT:
			Log.d("MAVLink", "GLOBAL_POSITION_SETPOINT_INT");
			return msg_global_position_setpoint_int.unpack(payload);
		case msg_set_global_position_setpoint_int.MAVLINK_MSG_ID_SET_GLOBAL_POSITION_SETPOINT_INT:
			Log.d("MAVLink", "SET_GLOBAL_POSITION_SETPOINT_INT");
			return msg_set_global_position_setpoint_int.unpack(payload);
		case msg_safety_set_allowed_area.MAVLINK_MSG_ID_SAFETY_SET_ALLOWED_AREA:
			Log.d("MAVLink", "SAFETY_SET_ALLOWED_AREA");
			return msg_safety_set_allowed_area.unpack(payload);
		case msg_safety_allowed_area.MAVLINK_MSG_ID_SAFETY_ALLOWED_AREA:
			Log.d("MAVLink", "SAFETY_ALLOWED_AREA");
			return msg_safety_allowed_area.unpack(payload);
		case msg_set_roll_pitch_yaw_thrust.MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_THRUST:
			Log.d("MAVLink", "SET_ROLL_PITCH_YAW_THRUST");
			return msg_set_roll_pitch_yaw_thrust.unpack(payload);
		case msg_set_roll_pitch_yaw_speed_thrust.MAVLINK_MSG_ID_SET_ROLL_PITCH_YAW_SPEED_THRUST:
			Log.d("MAVLink", "SET_ROLL_PITCH_YAW_SPEED_THRUST");
			return msg_set_roll_pitch_yaw_speed_thrust.unpack(payload);
		case msg_roll_pitch_yaw_thrust_setpoint.MAVLINK_MSG_ID_ROLL_PITCH_YAW_THRUST_SETPOINT:
			Log.d("MAVLink", "ROLL_PITCH_YAW_THRUST_SETPOINT");
			return msg_roll_pitch_yaw_thrust_setpoint.unpack(payload);
		case msg_roll_pitch_yaw_speed_thrust_setpoint.MAVLINK_MSG_ID_ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT:
			Log.d("MAVLink", "ROLL_PITCH_YAW_SPEED_THRUST_SETPOINT");
			return msg_roll_pitch_yaw_speed_thrust_setpoint.unpack(payload);
		case msg_set_quad_motors_setpoint.MAVLINK_MSG_ID_SET_QUAD_MOTORS_SETPOINT:
			Log.d("MAVLink", "SET_QUAD_MOTORS_SETPOINT");
			return msg_set_quad_motors_setpoint.unpack(payload);
		case msg_set_quad_swarm_roll_pitch_yaw_thrust.MAVLINK_MSG_ID_SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST:
			Log.d("MAVLink", "SET_QUAD_SWARM_ROLL_PITCH_YAW_THRUST");
			return msg_set_quad_swarm_roll_pitch_yaw_thrust.unpack(payload);
		case msg_nav_controller_output.MAVLINK_MSG_ID_NAV_CONTROLLER_OUTPUT:
			Log.d("MAVLink", "NAV_CONTROLLER_OUTPUT");
			return msg_nav_controller_output.unpack(payload);
		case msg_set_quad_swarm_led_roll_pitch_yaw_thrust.MAVLINK_MSG_ID_SET_QUAD_SWARM_LED_ROLL_PITCH_YAW_THRUST:
			Log.d("MAVLink", "SET_QUAD_SWARM_LED_ROLL_PITCH_YAW_THRUST");
			return msg_set_quad_swarm_led_roll_pitch_yaw_thrust.unpack(payload);
		case msg_state_correction.MAVLINK_MSG_ID_STATE_CORRECTION:
			Log.d("MAVLink", "STATE_CORRECTION");
			return msg_state_correction.unpack(payload);
		case msg_request_data_stream.MAVLINK_MSG_ID_REQUEST_DATA_STREAM:
			Log.d("MAVLink", "REQUEST_DATA_STREAM");
			return msg_request_data_stream.unpack(payload);
		case msg_data_stream.MAVLINK_MSG_ID_DATA_STREAM:
			Log.d("MAVLink", "DATA_STREAM");
			return msg_data_stream.unpack(payload);
		case msg_manual_control.MAVLINK_MSG_ID_MANUAL_CONTROL:
			Log.d("MAVLink", "MANUAL_CONTROL");
			return msg_manual_control.unpack(payload);
		case msg_rc_channels_override.MAVLINK_MSG_ID_RC_CHANNELS_OVERRIDE:
			Log.d("MAVLink", "RC_CHANNELS_OVERRIDE");
			return msg_rc_channels_override.unpack(payload);
		case msg_vfr_hud.MAVLINK_MSG_ID_VFR_HUD:
			Log.d("MAVLink", "VFR_HUD");
			return msg_vfr_hud.unpack(payload);
		case msg_command_long.MAVLINK_MSG_ID_COMMAND_LONG:
			Log.d("MAVLink", "COMMAND_LONG");
			return msg_command_long.unpack(payload);
		case msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK:
			Log.d("MAVLink", "COMMAND_ACK");
			return msg_command_ack.unpack(payload);
		case msg_roll_pitch_yaw_rates_thrust_setpoint.MAVLINK_MSG_ID_ROLL_PITCH_YAW_RATES_THRUST_SETPOINT:
			Log.d("MAVLink", "ROLL_PITCH_YAW_RATES_THRUST_SETPOINT");
			return msg_roll_pitch_yaw_rates_thrust_setpoint.unpack(payload);
		case msg_manual_setpoint.MAVLINK_MSG_ID_MANUAL_SETPOINT:
			Log.d("MAVLink", "MANUAL_SETPOINT");
			return msg_manual_setpoint.unpack(payload);
		case msg_local_position_ned_system_global_offset.MAVLINK_MSG_ID_LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET:
			Log.d("MAVLink", "LOCAL_POSITION_NED_SYSTEM_GLOBAL_OFFSET");
			return msg_local_position_ned_system_global_offset.unpack(payload);
		case msg_hil_state.MAVLINK_MSG_ID_HIL_STATE:
			Log.d("MAVLink", "HIL_STATE");
			return msg_hil_state.unpack(payload);
		case msg_hil_controls.MAVLINK_MSG_ID_HIL_CONTROLS:
			Log.d("MAVLink", "HIL_CONTROLS");
			return msg_hil_controls.unpack(payload);
		case msg_hil_rc_inputs_raw.MAVLINK_MSG_ID_HIL_RC_INPUTS_RAW:
			Log.d("MAVLink", "HIL_RC_INPUTS_RAW");
			return msg_hil_rc_inputs_raw.unpack(payload);
		case msg_optical_flow.MAVLINK_MSG_ID_OPTICAL_FLOW:
			Log.d("MAVLink", "OPTICAL_FLOW");
			return msg_optical_flow.unpack(payload);
		case msg_global_vision_position_estimate.MAVLINK_MSG_ID_GLOBAL_VISION_POSITION_ESTIMATE:
			Log.d("MAVLink", "GLOBAL_VISION_POSITION_ESTIMATE");
			return msg_global_vision_position_estimate.unpack(payload);
		case msg_vision_position_estimate.MAVLINK_MSG_ID_VISION_POSITION_ESTIMATE:
			Log.d("MAVLink", "VISION_POSITION_ESTIMATE");
			return msg_vision_position_estimate.unpack(payload);
		case msg_vision_speed_estimate.MAVLINK_MSG_ID_VISION_SPEED_ESTIMATE:
			Log.d("MAVLink", "VISION_SPEED_ESTIMATE");
			return msg_vision_speed_estimate.unpack(payload);
		case msg_vicon_position_estimate.MAVLINK_MSG_ID_VICON_POSITION_ESTIMATE:
			Log.d("MAVLink", "VICON_POSITION_ESTIMATE");
			return msg_vicon_position_estimate.unpack(payload);
		case msg_highres_imu.MAVLINK_MSG_ID_HIGHRES_IMU:
			Log.d("MAVLink", "HIGHRES_IMU");
			return msg_highres_imu.unpack(payload);
		case msg_omnidirectional_flow.MAVLINK_MSG_ID_OMNIDIRECTIONAL_FLOW:
			Log.d("MAVLink", "OMNIDIRECTIONAL_FLOW");
			return msg_omnidirectional_flow.unpack(payload);
		case msg_file_transfer_start.MAVLINK_MSG_ID_FILE_TRANSFER_START:
			Log.d("MAVLink", "FILE_TRANSFER_START");
			return msg_file_transfer_start.unpack(payload);
		case msg_file_transfer_dir_list.MAVLINK_MSG_ID_FILE_TRANSFER_DIR_LIST:
			Log.d("MAVLink", "FILE_TRANSFER_DIR_LIST");
			return msg_file_transfer_dir_list.unpack(payload);
		case msg_file_transfer_res.MAVLINK_MSG_ID_FILE_TRANSFER_RES:
			Log.d("MAVLink", "FILE_TRANSFER_RES");
			return msg_file_transfer_res.unpack(payload);
		case msg_battery_status.MAVLINK_MSG_ID_BATTERY_STATUS:
			Log.d("MAVLink", "BATTERY_STATUS");
			return msg_battery_status.unpack(payload);
		case msg_setpoint_8dof.MAVLINK_MSG_ID_SETPOINT_8DOF:
			Log.d("MAVLink", "SETPOINT_8DOF");
			return msg_setpoint_8dof.unpack(payload);
		case msg_setpoint_6dof.MAVLINK_MSG_ID_SETPOINT_6DOF:
			Log.d("MAVLink", "SETPOINT_6DOF");
			return msg_setpoint_6dof.unpack(payload);
		case msg_memory_vect.MAVLINK_MSG_ID_MEMORY_VECT:
			Log.d("MAVLink", "MEMORY_VECT");
			return msg_memory_vect.unpack(payload);
		case msg_debug_vect.MAVLINK_MSG_ID_DEBUG_VECT:
			Log.d("MAVLink", "DEBUG_VECT");
			return msg_debug_vect.unpack(payload);
		case msg_named_value_float.MAVLINK_MSG_ID_NAMED_VALUE_FLOAT:
			Log.d("MAVLink", "NAMED_VALUE_FLOAT");
			return msg_named_value_float.unpack(payload);
		case msg_named_value_int.MAVLINK_MSG_ID_NAMED_VALUE_INT:
			Log.d("MAVLink", "NAMED_VALUE_INT");
			return msg_named_value_int.unpack(payload);
		case msg_statustext.MAVLINK_MSG_ID_STATUSTEXT:
			Log.d("MAVLink", "STATUSTEXT");
			return msg_statustext.unpack(payload);
		case msg_debug.MAVLINK_MSG_ID_DEBUG:
			Log.d("MAVLink", "DEBUG");
			return msg_debug.unpack(payload);
		default:
			Log.d("MAVLink", "UNKNOW MESSAGE - " + msgid);
			return null;
		}
	}

	/*
	 * private MAVLinkMessage unpackGPS_RAW() { msg_gps_raw m = new
	 * msg_gps_raw(); m.usec = getInt64(0); m.fix_type = getInt8(8); m.lat =
	 * getInt32(12); m.lon = getInt32(16); m.alt = getInt32(20); m.eph =
	 * getInt16(24); m.epv = getInt16(26); m.v = getInt16(28); m. =
	 * getInt16(28); return m; }
	 */
}
	

package com.MAVLink.Messages;

import java.io.Serializable;

public abstract class MAVLinkMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *  Simply a common interface for all MAVLink Messages
	 */
	
	public int messageType = -1;
	
}

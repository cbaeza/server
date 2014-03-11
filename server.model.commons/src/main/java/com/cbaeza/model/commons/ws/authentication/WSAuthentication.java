package com.cbaeza.model.commons.ws.authentication;

import com.cbaeza.model.commons.ws.WS;

/**
 * User: cbaeza Since: 06.02.14
 */
public class WSAuthentication implements WS {

	private Long userID;
	private String username;
	private String token;

	/**
	 * Jackson need a empty constructor.
	 */
	public WSAuthentication() {
	}

	public WSAuthentication(Long userID, String username, String token) {
		this.userID = userID;
		this.username = username;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public Long getUserID() {
		return userID;
	}

	public String getToken() {
		return token;
	}
}

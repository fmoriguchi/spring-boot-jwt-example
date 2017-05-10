/**
 * 
 */
package com.fmoriguchi.security.jwt;

import java.io.Serializable;

/**
 * @author fmoriguchi
 *
 */
public final class Credentials implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public Credentials() {
	}
	
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

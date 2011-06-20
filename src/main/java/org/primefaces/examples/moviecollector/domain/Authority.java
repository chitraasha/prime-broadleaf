package org.primefaces.examples.moviecollector.domain;

import javax.persistence.Basic;


public class Authority {
	
	@Basic
	private String username;
	
	@Basic
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}

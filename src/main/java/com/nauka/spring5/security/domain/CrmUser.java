package com.nauka.spring5.security.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmUser {

	@NotNull(message="required")
	@Size(min=1, message="requiered")
	private String userName;
	
	@NotNull(message="required")
	@Size(min=1, message="requiered")
	private String password;

	public CrmUser() {}
	
	public CrmUser(@NotNull(message = "required") @Size(min = 1, message = "requiered") String username,
			@NotNull(message = "required") @Size(min = 1, message = "requiered") String password) {
		super();
		this.userName = username;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
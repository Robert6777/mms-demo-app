package com.tsystems.mms.demoapp.dto;

import com.tsystems.mms.demoapp.user.User;

public class UserItem {
	
	private String email;



	public UserItem(User user) {
		super();
		this.email = user.getEmail();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

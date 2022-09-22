package com.tsystems.mms.demoapp.dto;

import com.tsystems.mms.demoapp.user.UserGender;

public class UserCreationCommand {
	
	private String email;
	private String firstName;
	private String surname;
	private UserGender gender;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public UserGender getGender() {
		return gender;
	}

	public void setGender(UserGender gender) {
		this.gender = gender;
	}
	
	
	
	

}

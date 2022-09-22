package com.tsystems.mms.demoapp.dto;

import com.tsystems.mms.demoapp.user.User;
import com.tsystems.mms.demoapp.user.UserGender;

public class UserItem {
	
	private String email;
	private String firstName;
	private String surname;
	private String gender;



	public UserItem(User user) {
		super();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.surname = user.getSurname();
		this.gender = user.getGender().toString();

	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	


}

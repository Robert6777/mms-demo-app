package com.tsystems.mms.demoapp.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tsystems.mms.demoapp.organisational_unit.OrganisationalUnit;

public class UnitDto {
	
	
	private String name;
	private List<UserItem>users;
	
	public UnitDto() {
	}
	
	
	public UnitDto(OrganisationalUnit unit) {
		super();
		this.name = unit.getName();
		this.users = unit.getUsers().stream().map(UserItem::new).collect(Collectors.toList());
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<UserItem> getUsers() {
		return users;
	}


	public void setUsers(List<UserItem> users) {
		this.users = users;
	}
	
	
	
	
	

}

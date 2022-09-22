package com.tsystems.mms.demoapp.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tsystems.mms.demoapp.dto.UserCreationCommand;
import com.tsystems.mms.demoapp.organisational_unit.OrganisationalUnit;

import java.io.Serializable;

@Entity
@Table(name = "demo_user")
public class User implements Serializable {

  private static final long serialVersionUID = 1715994813284718249L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  protected Long id;

  @Column(name = "email", nullable = false)
  private String email;
  
  @Column(name = "firstname", nullable = false)
  private String firstName;
  
  @Column(name = "surname", nullable = false)
  private String surname;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "gender", nullable = false)
  private UserGender gender;
  

  

  
  
  
  public User() {
	}

	public User(UserCreationCommand command) {
		super();
		this.email = command.getEmail();
		this.firstName = command.getFirstName();
		this.surname = command.getSurname();
		this.gender = command.getGender();
		
	}
  
  
  

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

public UserGender getGender() {
	return gender;
}

public void setGender(UserGender gender) {
	this.gender = gender;
}
  
  
  
  
  
  
}

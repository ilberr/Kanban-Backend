package org.rygn.kanban.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Developer {

	private @Id @GeneratedValue Long id;
	  
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String password;
	
	private LocalDate startContract;
	 
	public Developer() {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getStartContract() {
		return startContract;
	}

	public void setStartContract(LocalDate startContract) {
		this.startContract = startContract;
	}
	
	
}

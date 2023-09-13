package com.adacho.model;

import java.time.LocalDateTime;

import com.adacho.service.WrongIdPasswordException;

public class Member {
	private long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}
	
	public long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPasword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}

	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}


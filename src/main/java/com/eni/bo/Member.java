package com.eni.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Member {
	@Min(value=1, message="Should be greater than 0")
	private long id;
	@NotBlank
	private String lastName;
	@NotBlank
	private String firstName;
	@NotBlank
	private String login;
	@NotBlank
	private String password;
	private boolean isAdmin;

	public Member() {
	}

	public Member(long id, String lastName, String firstName, String login, String password, boolean isAdmin) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", login=" + login
				+ ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

}

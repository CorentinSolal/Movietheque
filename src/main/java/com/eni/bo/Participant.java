package com.eni.bo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Participant {
	@Min(value=1, message="Should be greater than 0")
	private long id;
	@NotBlank
	private String lastName;
	@NotBlank
	private String firstName;

	public Participant() {
	}

	public Participant(long id, String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(" ");
		builder.append(lastName);
		builder.append(" [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	
}

package com.justkaira.ms.model;

public class User {

//	@Id
	public String id;

	public String firstName;
	public String lastName;

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

}

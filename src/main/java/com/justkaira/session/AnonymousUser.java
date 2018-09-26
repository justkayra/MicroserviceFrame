package com.justkaira.session;

public class AnonymousUser implements IUser {
	public final static String USER_NAME = "anonymous";
	public final static long ID = 0;

	public String getUserID() {
		return USER_NAME;
	}

	public String getUserName() {
		return USER_NAME;
	}

	@Override
	public Long getId() {
		return (long) ID;
	}

	public String getLogin() {
		return USER_NAME;
	}

	public boolean isAnonymous() {
		return true;
	}

}

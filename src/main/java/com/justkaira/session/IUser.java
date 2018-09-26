package com.justkaira.session;

public interface IUser {
	Long getId();

	default boolean isSuperUser() {
		return false;
	}

}

package com.justkaira.exception;

public class MSException extends Exception {
	private static final long serialVersionUID = 1L;
	private String addInfo;

	public MSException(Exception exception) {
		super(exception);
		addInfo = exception.getMessage();
	}

}

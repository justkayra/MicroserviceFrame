package com.justkaira.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "type", "addInfo"})
public class MSException extends Exception {
	private static final long serialVersionUID = 1L;
	private MSExceptionType type = MSExceptionType.RUNTIME_ERROR;
	private String addInfo;

	public MSException(Exception exception) {
		super(exception);
		addInfo = exception.getMessage();
	}

	public MSException(MSExceptionType type, String addInfo) {
		this.type = type;
		this.addInfo = addInfo;
	}

	public MSException(MSExceptionType runtimeError, Exception e) {
		super(e);
		this.type = runtimeError;
		addInfo = e.getMessage();
	}

	public MSExceptionType getType() {
		return type;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public String getMessage(){
		if (type == MSExceptionType.RUNTIME_ERROR){
			return addInfo;
		}else{
			return type.name() + ":" + addInfo;
		}

	}
}

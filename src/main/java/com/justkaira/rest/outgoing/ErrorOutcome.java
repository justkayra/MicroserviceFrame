package com.justkaira.rest.outgoing;

import com.justkaira.exception.MSException;


public class ErrorOutcome extends Outcome {
	public static final String ERROR_PAYLOAD = "error";

	public ErrorOutcome(MSException e) {
		super();
		payload.put(ERROR_PAYLOAD, e);
	}
}

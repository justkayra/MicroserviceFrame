package com.justkaira.rest.outgoing;

import javax.xml.bind.annotation.XmlRootElement;

import com.justkaira.exception.MSException;

@XmlRootElement
public class ErrorOutcome extends Outcome {
	public static final String ERROR_PAYLOAD = "error";

	public ErrorOutcome(MSException e) {
		super();
		payload.put(ERROR_PAYLOAD, e);
	}
}

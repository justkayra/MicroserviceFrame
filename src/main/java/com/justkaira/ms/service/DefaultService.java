package com.justkaira.ms.service;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justkaira.rest.outgoing.Outcome;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class DefaultService implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping("/")
	public HttpEntity<Outcome> get() {
		return getIndex();
	}

	@RequestMapping("/index")
	public HttpEntity<Outcome> getIndex() {
		Outcome outcome = new Outcome();
		outcome.addPayload("bom dia");
		return new ResponseEntity<>(outcome, HttpStatus.OK);
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}

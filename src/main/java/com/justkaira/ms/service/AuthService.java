package com.justkaira.ms.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justkaira.ms.controller.AuthController;
import com.justkaira.ms.model.Credential;
import com.justkaira.rest.outgoing.Outcome;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class AuthService {
	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/doauth")
	public HttpEntity<Outcome> doAuth(Credential credential) {

		AuthController authContr = new AuthController();
		authContr.check(credential);

		Outcome outcome = new Outcome();
		return new ResponseEntity<>(outcome, HttpStatus.OK);
	}

}

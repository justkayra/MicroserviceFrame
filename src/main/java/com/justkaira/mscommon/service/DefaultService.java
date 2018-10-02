package com.justkaira.mscommon.service;

import com.justkaira.env.Environment;
import com.justkaira.mscommon.controller.IServiceInteraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.justkaira.rest.outgoing.Outcome;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class DefaultService implements ErrorController {

	private static final String PATH = "/error";


	@Autowired
	public RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping("/")
	public HttpEntity<Outcome> get() {
		return getIndex();
	}

	@RequestMapping("/index")
	public HttpEntity<Outcome> getIndex() {
		Outcome outcome = new Outcome();
		try {
			Class<IServiceInteraction> serviceInteractionClass = (Class<IServiceInteraction>) Class.forName(Environment.SERVICE_PACKAGE + ".service.ServiceInfoProvider");
			IServiceInteraction serviceInteraction = serviceInteractionClass.newInstance();
			outcome.addPayload(serviceInteraction.getEndpoints());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(outcome, HttpStatus.OK);
	}

	@RequestMapping("/endpoints")
	public HttpEntity<Outcome> showEndpointsAction(){
		return new ResponseEntity<>(new Outcome().addPayload(requestMappingHandlerMapping.getHandlerMethods().keySet().stream().map(t ->
				(t.getMethodsCondition().getMethods().size() == 0 ? "GET" : t.getMethodsCondition().getMethods().toArray()[0]) + " " +
						t.getPatternsCondition().getPatterns().toArray()[0]
		).toArray()), HttpStatus.OK);
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}

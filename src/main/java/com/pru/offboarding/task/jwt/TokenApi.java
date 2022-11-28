package com.pru.offboarding.task.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/token")
public class TokenApi {
	
	@Autowired
	private JwtTokenUtilService service;
	Logger lk=LoggerFactory.getLogger(TokenApi.class);
	
	@PostMapping("/get")
	public AuthResponse getToken(@RequestBody AuthRequest request) throws JsonProcessingException{
		return service.getAccessToken(request);
	}
	
}

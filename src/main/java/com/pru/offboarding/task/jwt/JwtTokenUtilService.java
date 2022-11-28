package com.pru.offboarding.task.jwt;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pru.offboarding.task.user.Role;
import com.pru.offboarding.task.user.User;

@Service
public class JwtTokenUtilService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private String getUrl(){
		Optional<String> os = this.discoveryClient.getServices().stream().filter(s->s.startsWith("token")).findFirst();
		 String url="http://"+os.get().toUpperCase();
		 return url;
	}

	public AuthResponse getAccessToken(AuthRequest aurq) throws JsonProcessingException {
		URI lk = URI.create(getUrl()+"/auth/login");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AuthRequest> entity=new HttpEntity<AuthRequest>(aurq,headers);
		AuthResponse s2 = restTemplate.postForObject(lk, entity, AuthResponse.class);				
		return s2;
	}
	
	public boolean validateToken(String token) {
		URI uri=URI.create(getUrl()+"/token/validate-token");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity=new HttpEntity<String>(token.trim(), headers);
		Boolean valid = restTemplate.postForObject(uri, entity, Boolean.class);
		return valid;
	}
	
	public User getUserDetails(String token){
		URI uri=URI.create(getUrl()+"/token/get-claim");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity=new HttpEntity<String>(token.trim(), headers);
		Map<String, Object> userDetailsMap = restTemplate.postForObject(uri, entity, Map.class);
		
		User userDetails = new User();
		for (Map.Entry<String, Object> entry : userDetailsMap.entrySet()) {
			String key = entry.getKey();
			Object val = entry.getValue();
			if(key.equalsIgnoreCase("sub")) {
				String s1=(String)val;
				String[] jwtSubject = s1.split(",");
				userDetails.setId(jwtSubject[0]);
				userDetails.setEmail(jwtSubject[1]);
			}
			if(key.equalsIgnoreCase("roles")) {
				String roles = (String)val;
				roles = roles.replace("[", "").replace("]", "");
				String[] roleNames = roles.split(",");
				for (String aRoleName : roleNames) {
					userDetails.addRole(new Role(aRoleName));
				}
			}
			
		}
		
		return userDetails;
	}
}

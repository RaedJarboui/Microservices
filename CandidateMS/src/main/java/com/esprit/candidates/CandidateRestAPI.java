package com.esprit.candidates;

import org.springframework.web.bind.annotation.RequestMapping;

public class CandidateRestAPI {
	private String title="Hello, I'm the candidate Microservice";
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

}

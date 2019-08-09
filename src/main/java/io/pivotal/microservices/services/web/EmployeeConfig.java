package io.pivotal.microservices.services.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeConfig {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world from Valeri!";
	}
	
	@RequestMapping(value = "/hello2", produces = "application/json")
	public Employee hello2() {
		return new Employee();
	}
	
}
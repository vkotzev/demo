package io.pivotal.microservices.services.web;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String id;
	private String egn;
	private String firstName;
	private String lastName;
	private List<String> addresses = new ArrayList<>();
	
	public Employee() {
		this.id = "5";
		this.egn = "7777777777";
		this.firstName = "Valeri";
		this.lastName = "Kotsev";
		addresses.add("ValKot Address 1");
		addresses.add("ValKot Address 22");
		addresses.add("ValKot Address 333");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEgn() {
		return egn;
	}

	public void setEgn(String egn) {
		this.egn = egn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

}

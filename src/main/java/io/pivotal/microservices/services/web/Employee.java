package io.pivotal.microservices.services.web;

import java.util.ArrayList;

public class Employee {
	
	private long id;
	private String egn;
	private String name;
	private String family;
	private ArrayList<String> team;
	
	public Employee() {
		this.id = 5;
		this.egn = "7777777777";
		this.name = "Valeri";
		this.family = "Kotsev";
		team = new ArrayList<String>();
		team.add("Djako Bokanako 1");
		team.add("Djako Bokanako 2");
		team.add("Djako Bokanako 3");
		team.add("Djako Bokanako 4");
		team.add("Djako Bokanako 5");
		team.add("Djako Bokanako 6");
		team.add("Djako Bokanako 7");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEgn() {
		return egn;
	}

	public void setEgn(String egn) {
		this.egn = egn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public ArrayList<String> getTeam() {
		return team;
	}

	public void setTeam(ArrayList<String> team) {
		this.team = team;
	}
}

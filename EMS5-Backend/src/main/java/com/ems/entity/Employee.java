package com.ems.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "home_location_id", referencedColumnName = "id")
	private Location homeLocation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "office_location_id", referencedColumnName = "id")
	private Location officeLocation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(Location homeLocation) {
		this.homeLocation = homeLocation;
	}

	public Location getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(Location officeLocation) {
		this.officeLocation = officeLocation;
	}

	public Employee(Long id, String name, Location homeLocation, Location officeLocation) {
		super();
		this.id = id;
		this.name = name;
		this.homeLocation = homeLocation;
		this.officeLocation = officeLocation;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}

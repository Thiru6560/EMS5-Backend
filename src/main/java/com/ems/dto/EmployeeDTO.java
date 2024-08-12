package com.ems.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {

	@NotBlank(message = "Enter Name")
	private String name;
	
	@NotBlank(message = "Enter Role")
	private String role;
//	@NotBlank(message = "Enter Home Location")
	private LocationDTO homeLocation;
//	@NotBlank(message = "Enter Office Location")
	private LocationDTO officeLocation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocationDTO getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(LocationDTO homeLocation) {
		this.homeLocation = homeLocation;
	}

	public LocationDTO getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(LocationDTO officeLocation) {
		this.officeLocation = officeLocation;
	}

}

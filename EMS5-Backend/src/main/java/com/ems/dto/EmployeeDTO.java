package com.ems.dto;

public class EmployeeDTO {

	private String name;
	private LocationDTO homeLocation;
	private LocationDTO officeLocation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

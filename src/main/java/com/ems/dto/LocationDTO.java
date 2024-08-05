package com.ems.dto;

import jakarta.validation.constraints.NotBlank;

public class LocationDTO {

	@NotBlank(message = "Enter Type of Location")
	private String type;
	@NotBlank(message = "Enter Latitude")
	private String latitude;
	@NotBlank(message = "Enter Longitude")
	private String longitude;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}

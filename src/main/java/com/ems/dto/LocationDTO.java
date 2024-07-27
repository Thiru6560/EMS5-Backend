package com.ems.dto;

import jakarta.validation.constraints.NotBlank;

public class LocationDTO {

	@NotBlank(message = "Enter Type of Location")
	private String type;
	@NotBlank(message = "Enter Latitude")
	private Double latitude;
	@NotBlank(message = "Enter Longitude")
	private Double longitude;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}

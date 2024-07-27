package com.ems.dto;

import jakarta.validation.constraints.NotBlank;

public class LatLon {

	@NotBlank(message = "Enter Latitude")
	private double lat;

	@NotBlank(message = "Enter Longitude")
	private double lon;

	public LatLon(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
}

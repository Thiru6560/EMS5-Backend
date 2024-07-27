package com.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;

	private Double homeLatitude;

	private Double homeLongitude;

	private Double officeLatitude;

	private Double officeLongitude;

//	@OneToOne(mappedBy = "location")
//	@JoinColumn(name = "employee_id",referencedColumnName = "id")
//	private Employee employee;

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Double getHomeLatitude() {
		return homeLatitude;
	}

	public void setHomeLatitude(Double homeLatitude) {
		this.homeLatitude = homeLatitude;
	}

	public Double getHomeLongitude() {
		return homeLongitude;
	}

	public void setHomeLongitude(Double homeLongitude) {
		this.homeLongitude = homeLongitude;
	}

	public Double getOfficeLatitude() {
		return officeLatitude;
	}

	public void setOfficeLatitude(Double officeLatitude) {
		this.officeLatitude = officeLatitude;
	}

	public Double getOfficeLongitude() {
		return officeLongitude;
	}

	public void setOfficeLongitude(Double officeLongitude) {
		this.officeLongitude = officeLongitude;
	}

	public Location(Long locationId, Double homeLatitude, Double homeLongitude, Double officeLatitude,
			Double officeLongitude) {
		super();
		this.locationId = locationId;
		this.homeLatitude = homeLatitude;
		this.homeLongitude = homeLongitude;
		this.officeLatitude = officeLatitude;
		this.officeLongitude = officeLongitude;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

}

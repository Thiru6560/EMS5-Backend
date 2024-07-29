package com.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Holiday")
public class HolidayEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer holidayId;
	private String holidayName;
	private LocalDate date;
	private String description;

	public Integer getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}

	public String getHolidayname() {
		return holidayName;
	}

	public void setHolidayname(String holidayname) {
		this.holidayName = holidayname;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HolidayEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HolidayEntity(Integer holidayId, String holidayName, LocalDate date, String description) {
		super();
		this.holidayId = holidayId;
		this.holidayName = holidayName;
		this.date = date;
		this.description = description;
	}

}

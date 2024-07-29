package com.ems.dto;

import java.time.LocalDate;

public class HolidayDto {
	private String holidayName;
	private LocalDate date;
	private String description;

	public HolidayDto() {
		super();
		// TODO Auto-generated constructor stub
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

}

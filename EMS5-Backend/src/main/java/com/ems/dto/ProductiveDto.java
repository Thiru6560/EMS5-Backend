package com.ems.dto;

import java.time.LocalDate;

public class ProductiveDto {
	
    private LocalDate date;
	
	private Double totalHoursWorked;
	
	private Double breakTime;
	
	private Double productiveHours;
	
	
	public ProductiveDto( LocalDate date, Double totalHoursWorked, Double breakTime,Double productiveHours) {
		super();
		this.date = date;
		this.totalHoursWorked = totalHoursWorked;
		this.breakTime = breakTime;
		this.productiveHours = productiveHours;
	}
	
	public ProductiveDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public Double getTotalHoursWorked() {
		return totalHoursWorked;
	}


	public void setTotalHoursWorked(Double totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}


	public Double getBreakTime() {
		return breakTime;
	}


	public void setBreakTime(Double breakTime) {
		this.breakTime = breakTime;
	}


	public Double getProductiveHours() {
		return productiveHours;
	}


	public void setProductiveHours(Double productiveHours) {
		this.productiveHours = productiveHours;
	}


}

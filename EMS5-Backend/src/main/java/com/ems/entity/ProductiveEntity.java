
package com.ems.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "productive")
public class ProductiveEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@NotNull(message = "Employee ID cannot be null")
	private Long employee_ID;
	
	@NotNull(message = "Work date cannot be null")
    @PastOrPresent(message = "Work date cannot be in the future")
	private LocalDate date;
	
	@NotNull(message = "Total hours worked cannot be null")
    @Min(value = 0, message = "Total hours worked must be at least 0")
	
	private Double totalHoursWorked;
	
	@NotNull(message = "Break time cannot be null")
    @Min(value = 0, message = "Break time must be at least 0")
	
	private Double breakTime;
	
	@NotNull(message = "Productive hours cannot be null")
    @Min(value = 0, message = "Productive hours must be at least 0")

	
	private Double productiveHours;
	
	
	

	
	public Long getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(Long employee_ID) {
		this.employee_ID = employee_ID;
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

package com.ems.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="attendance")
public class AttendanceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long attendanceId;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	private LocalDateTime clockInTime;
	
	private LocalDateTime clockOutTime;
	
	private LocalDate date;
	
	 private String status; 
	 
	 private String comments;

	 
	

	public LocalDateTime getClockInTime() {
		return clockInTime;
	}

	public void setClockInTime(LocalDateTime clockInTime) {
		this.clockInTime = clockInTime;
	}

	public LocalDateTime getClockOutTime() {
		return clockOutTime;
	}

	public void setClockOutTime(LocalDateTime clockOutTime) {
		this.clockOutTime = clockOutTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
}

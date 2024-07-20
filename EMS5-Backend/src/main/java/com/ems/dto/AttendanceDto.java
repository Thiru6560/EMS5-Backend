package com.ems.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceDto {

		
	private LocalDateTime clockInTime;
	
	private LocalDateTime clockOutTime;
	
	private LocalDate date;
	
	 private String status; 
	 
	 private String comments;
	 
	 
	 
	 public AttendanceDto(LocalDateTime clockInTime, LocalDateTime clockOutTime, LocalDate date,String status,String comments) {
			super();
			this.clockInTime = clockInTime;
			this.clockOutTime = clockOutTime;
			this.date = date;
			this.status=status;
			this.comments=comments;
		}
	 
	 public AttendanceDto() {
			super();
			// TODO Auto-generated constructor stub
		}

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

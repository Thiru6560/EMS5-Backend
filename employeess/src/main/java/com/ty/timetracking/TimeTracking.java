package com.ty.timetracking;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_tracking")
public class TimeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "clock_in")
    private LocalDateTime clockIn;

    @Column(name = "clock_out")
    private LocalDateTime clockOut;

    @Column(name = "break_start")
    private LocalDateTime breakStart;

    @Column(name = "break_end")
    private LocalDateTime breakEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDateTime getClockIn() {
		return clockIn;
	}

	public void setClockIn(LocalDateTime clockIn) {
		this.clockIn = clockIn;
	}

	public LocalDateTime getClockOut() {
		return clockOut;
	}

	public void setClockOut(LocalDateTime clockOut) {
		this.clockOut = clockOut;
	}

	public LocalDateTime getBreakStart() {
		return breakStart;
	}

	public void setBreakStart(LocalDateTime breakStart) {
		this.breakStart = breakStart;
	}

	public LocalDateTime getBreakEnd() {
		return breakEnd;
	}

	public void setBreakEnd(LocalDateTime breakEnd) {
		this.breakEnd = breakEnd;
	}

	public TimeTracking(Long id, Long employeeId, LocalDateTime clockIn, LocalDateTime clockOut,
			LocalDateTime breakStart, LocalDateTime breakEnd) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.clockIn = clockIn;
		this.clockOut = clockOut;
		this.breakStart = breakStart;
		this.breakEnd = breakEnd;
	}
	public TimeTracking() {}
   
}






package com.shift.Entity;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Monday {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mon_id;

	//this is entity class
	private Time shiftStartTime;

	private Time shiftEndTime;

	private Time lunchBreakStartTime;

	private Time lunchBreakEndTime;

	private Integer takeLunchBreakBeforeMinute;

	private Time teaBreakStartTime;

	private Time teaBreakEndTime;

	private Time takeTeaBreakBeforeMinute;

	private Time halfDayAfterTime;

	private Time halfDayBeforeTime;

	private Integer lateInCountAfterMinutes;

	private Integer earlyOutCountBeforeMinutes;

	private Integer minimumHalfDayHours;

	private Integer maximumPersonalBreak;

	private Time maximumPunchOutTime;

	private Integer maximumPunchOutHours;

	public Monday(Long mon_id, Time shiftStartTime, Time shiftEndTime, Time lunchBreakStartTime, Time lunchBreakEndTime,
			Integer takeLunchBreakBeforeMinute, Time teaBreakStartTime, Time teaBreakEndTime,
			Time takeTeaBreakBeforeMinute, Time halfDayAfterTime, Time halfDayBeforeTime,
			Integer lateInCountAfterMinutes, Integer earlyOutCountBeforeMinutes, Integer minimumHalfDayHours,
			Integer maximumPersonalBreak, Time maximumPunchOutTime, Integer maximumPunchOutHours) {
		super();
		this.mon_id = mon_id;
		this.shiftStartTime = shiftStartTime;
		this.shiftEndTime = shiftEndTime;
		this.lunchBreakStartTime = lunchBreakStartTime;
		this.lunchBreakEndTime = lunchBreakEndTime;
		this.takeLunchBreakBeforeMinute = takeLunchBreakBeforeMinute;
		this.teaBreakStartTime = teaBreakStartTime;
		this.teaBreakEndTime = teaBreakEndTime;
		this.takeTeaBreakBeforeMinute = takeTeaBreakBeforeMinute;
		this.halfDayAfterTime = halfDayAfterTime;
		this.halfDayBeforeTime = halfDayBeforeTime;
		this.lateInCountAfterMinutes = lateInCountAfterMinutes;
		this.earlyOutCountBeforeMinutes = earlyOutCountBeforeMinutes;
		this.minimumHalfDayHours = minimumHalfDayHours;
		this.maximumPersonalBreak = maximumPersonalBreak;
		this.maximumPunchOutTime = maximumPunchOutTime;
		this.maximumPunchOutHours = maximumPunchOutHours;
	}

	public Long getMon_id() {
		return mon_id;
	}

	public void setMon_id(Long mon_id) {
		this.mon_id = mon_id;
	}

	public Time getShiftStartTime() {
		return shiftStartTime;
	}

	public void setShiftStartTime(Time shiftStartTime) {
		this.shiftStartTime = shiftStartTime;
	}

	public Time getShiftEndTime() {
		return shiftEndTime;
	}

	public void setShiftEndTime(Time shiftEndTime) {
		this.shiftEndTime = shiftEndTime;
	}

	public Time getLunchBreakStartTime() {
		return lunchBreakStartTime;
	}

	public void setLunchBreakStartTime(Time lunchBreakStartTime) {
		this.lunchBreakStartTime = lunchBreakStartTime;
	}

	public Time getLunchBreakEndTime() {
		return lunchBreakEndTime;
	}

	public void setLunchBreakEndTime(Time lunchBreakEndTime) {
		this.lunchBreakEndTime = lunchBreakEndTime;
	}

	public Integer getTakeLunchBreakBeforeMinute() {
		return takeLunchBreakBeforeMinute;
	}

	public void setTakeLunchBreakBeforeMinute(Integer takeLunchBreakBeforeMinute) {
		this.takeLunchBreakBeforeMinute = takeLunchBreakBeforeMinute;
	}

	public Time getTeaBreakStartTime() {
		return teaBreakStartTime;
	}

	public void setTeaBreakStartTime(Time teaBreakStartTime) {
		this.teaBreakStartTime = teaBreakStartTime;
	}

	public Time getTeaBreakEndTime() {
		return teaBreakEndTime;
	}

	public void setTeaBreakEndTime(Time teaBreakEndTime) {
		this.teaBreakEndTime = teaBreakEndTime;
	}

	public Time getTakeTeaBreakBeforeMinute() {
		return takeTeaBreakBeforeMinute;
	}

	public void setTakeTeaBreakBeforeMinute(Time takeTeaBreakBeforeMinute) {
		this.takeTeaBreakBeforeMinute = takeTeaBreakBeforeMinute;
	}

	public Time getHalfDayAfterTime() {
		return halfDayAfterTime;
	}

	public void setHalfDayAfterTime(Time halfDayAfterTime) {
		this.halfDayAfterTime = halfDayAfterTime;
	}

	public Time getHalfDayBeforeTime() {
		return halfDayBeforeTime;
	}

	public void setHalfDayBeforeTime(Time halfDayBeforeTime) {
		this.halfDayBeforeTime = halfDayBeforeTime;
	}

	public Integer getLateInCountAfterMinutes() {
		return lateInCountAfterMinutes;
	}

	public void setLateInCountAfterMinutes(Integer lateInCountAfterMinutes) {
		this.lateInCountAfterMinutes = lateInCountAfterMinutes;
	}

	public Integer getEarlyOutCountBeforeMinutes() {
		return earlyOutCountBeforeMinutes;
	}

	public void setEarlyOutCountBeforeMinutes(Integer earlyOutCountBeforeMinutes) {
		this.earlyOutCountBeforeMinutes = earlyOutCountBeforeMinutes;
	}

	public Integer getMinimumHalfDayHours() {
		return minimumHalfDayHours;
	}

	public void setMinimumHalfDayHours(Integer minimumHalfDayHours) {
		this.minimumHalfDayHours = minimumHalfDayHours;
	}

	public Integer getMaximumPersonalBreak() {
		return maximumPersonalBreak;
	}

	public void setMaximumPersonalBreak(Integer maximumPersonalBreak) {
		this.maximumPersonalBreak = maximumPersonalBreak;
	}

	public Time getMaximumPunchOutTime() {
		return maximumPunchOutTime;
	}

	public void setMaximumPunchOutTime(Time maximumPunchOutTime) {
		this.maximumPunchOutTime = maximumPunchOutTime;
	}

	public Integer getMaximumPunchOutHours() {
		return maximumPunchOutHours;
	}

	public void setMaximumPunchOutHours(Integer maximumPunchOutHours) {
		this.maximumPunchOutHours = maximumPunchOutHours;
	}

	public Monday() {
		super();
	}

}

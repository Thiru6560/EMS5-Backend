package com.shift.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ShiftEntity {
	@Id
	@SequenceGenerator(name = "userid_sequence_table")
	@GeneratedValue(generator = "user-id-generator")
	@GenericGenerator(name = "user-id-generator", strategy = "com.shift.Generator.UserIdGenerator")
	private String shiftId;

	private String shiftName;

	private String hasAutoWeekOff;
	private Integer weekOffDays;
	private String hasAlternateWeekOff;
	private Integer maximumLateIn;
	private Integer maximumEarlyOut;
	private String applyHalfDayifLateInLimitExceeded;
	private String multiplePunchInOutAllow;
	private String requiredOutOfRangeReason;
	private String allowShortLeave;
	private String applySandwichLeave;
	private String takeBreakSettings;
	private String addPaidLeaveonExtraDay;
	private String lateInEarlyOutApplyOnExtraDay;
	private String applyLeaveOnHoliday;
	private String applyLeaveOnWeekOff;
	private String reasonOfLateIn;
	private String reasonOfEarlyOut;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "mon_id")
	private Monday monday;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tue_id")
	private Tuesday tuesday;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "wed_id")
	private Wednesday wednesday;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "thu_id")
	private Thursday thursday;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fri_id")
	private Friday friday;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sat_id")
	private Saturday saturday;

	public ShiftEntity(String shiftId, String shiftName, String hasAutoWeekOff, Integer weekOffDays,
			String hasAlternateWeekOff, Integer maximumLateIn, Integer maximumEarlyOut,
			String applyHalfDayifLateInLimitExceeded, String multiplePunchInOutAllow, String requiredOutOfRangeReason,
			String allowShortLeave, String applySandwichLeave, String takeBreakSettings, String addPaidLeaveonExtraDay,
			String lateInEarlyOutApplyOnExtraDay, String applyLeaveOnHoliday, String applyLeaveOnWeekOff,
			String reasonOfLateIn, String reasonOfEarlyOut, Monday monday, Tuesday tuesday, Wednesday wednesday,
			Thursday thursday, Friday friday, Saturday saturday) {
		super();
		this.shiftId = shiftId;
		this.shiftName = shiftName;
		this.hasAutoWeekOff = hasAutoWeekOff;
		this.weekOffDays = weekOffDays;
		this.hasAlternateWeekOff = hasAlternateWeekOff;
		this.maximumLateIn = maximumLateIn;
		this.maximumEarlyOut = maximumEarlyOut;
		this.applyHalfDayifLateInLimitExceeded = applyHalfDayifLateInLimitExceeded;
		this.multiplePunchInOutAllow = multiplePunchInOutAllow;
		this.requiredOutOfRangeReason = requiredOutOfRangeReason;
		this.allowShortLeave = allowShortLeave;
		this.applySandwichLeave = applySandwichLeave;
		this.takeBreakSettings = takeBreakSettings;
		this.addPaidLeaveonExtraDay = addPaidLeaveonExtraDay;
		this.lateInEarlyOutApplyOnExtraDay = lateInEarlyOutApplyOnExtraDay;
		this.applyLeaveOnHoliday = applyLeaveOnHoliday;
		this.applyLeaveOnWeekOff = applyLeaveOnWeekOff;
		this.reasonOfLateIn = reasonOfLateIn;
		this.reasonOfEarlyOut = reasonOfEarlyOut;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
	}

	public String getShiftId() {
		return shiftId;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public String getHasAutoWeekOff() {
		return hasAutoWeekOff;
	}

	public void setHasAutoWeekOff(String hasAutoWeekOff) {
		this.hasAutoWeekOff = hasAutoWeekOff;
	}

	public Integer getWeekOffDays() {
		return weekOffDays;
	}

	public void setWeekOffDays(Integer weekOffDays) {
		this.weekOffDays = weekOffDays;
	}

	public String getHasAlternateWeekOff() {
		return hasAlternateWeekOff;
	}

	public void setHasAlternateWeekOff(String hasAlternateWeekOff) {
		this.hasAlternateWeekOff = hasAlternateWeekOff;
	}

	public Integer getMaximumLateIn() {
		return maximumLateIn;
	}

	public void setMaximumLateIn(Integer maximumLateIn) {
		this.maximumLateIn = maximumLateIn;
	}

	public Integer getMaximumEarlyOut() {
		return maximumEarlyOut;
	}

	public void setMaximumEarlyOut(Integer maximumEarlyOut) {
		this.maximumEarlyOut = maximumEarlyOut;
	}

	public String getApplyHalfDayifLateInLimitExceeded() {
		return applyHalfDayifLateInLimitExceeded;
	}

	public void setApplyHalfDayifLateInLimitExceeded(String applyHalfDayifLateInLimitExceeded) {
		this.applyHalfDayifLateInLimitExceeded = applyHalfDayifLateInLimitExceeded;
	}

	public String getMultiplePunchInOutAllow() {
		return multiplePunchInOutAllow;
	}

	public void setMultiplePunchInOutAllow(String multiplePunchInOutAllow) {
		this.multiplePunchInOutAllow = multiplePunchInOutAllow;
	}

	public String getRequiredOutOfRangeReason() {
		return requiredOutOfRangeReason;
	}

	public void setRequiredOutOfRangeReason(String requiredOutOfRangeReason) {
		this.requiredOutOfRangeReason = requiredOutOfRangeReason;
	}

	public String getAllowShortLeave() {
		return allowShortLeave;
	}

	public void setAllowShortLeave(String allowShortLeave) {
		this.allowShortLeave = allowShortLeave;
	}

	public String getApplySandwichLeave() {
		return applySandwichLeave;
	}

	public void setApplySandwichLeave(String applySandwichLeave) {
		this.applySandwichLeave = applySandwichLeave;
	}

	public String getTakeBreakSettings() {
		return takeBreakSettings;
	}

	public void setTakeBreakSettings(String takeBreakSettings) {
		this.takeBreakSettings = takeBreakSettings;
	}

	public String getAddPaidLeaveonExtraDay() {
		return addPaidLeaveonExtraDay;
	}

	public void setAddPaidLeaveonExtraDay(String addPaidLeaveonExtraDay) {
		this.addPaidLeaveonExtraDay = addPaidLeaveonExtraDay;
	}

	public String getLateInEarlyOutApplyOnExtraDay() {
		return lateInEarlyOutApplyOnExtraDay;
	}

	public void setLateInEarlyOutApplyOnExtraDay(String lateInEarlyOutApplyOnExtraDay) {
		this.lateInEarlyOutApplyOnExtraDay = lateInEarlyOutApplyOnExtraDay;
	}

	public String getApplyLeaveOnHoliday() {
		return applyLeaveOnHoliday;
	}

	public void setApplyLeaveOnHoliday(String applyLeaveOnHoliday) {
		this.applyLeaveOnHoliday = applyLeaveOnHoliday;
	}

	public String getApplyLeaveOnWeekOff() {
		return applyLeaveOnWeekOff;
	}

	public void setApplyLeaveOnWeekOff(String applyLeaveOnWeekOff) {
		this.applyLeaveOnWeekOff = applyLeaveOnWeekOff;
	}

	public String getReasonOfLateIn() {
		return reasonOfLateIn;
	}

	public void setReasonOfLateIn(String reasonOfLateIn) {
		this.reasonOfLateIn = reasonOfLateIn;
	}

	public String getReasonOfEarlyOut() {
		return reasonOfEarlyOut;
	}

	public void setReasonOfEarlyOut(String reasonOfEarlyOut) {
		this.reasonOfEarlyOut = reasonOfEarlyOut;
	}

	public Monday getMonday() {
		return monday;
	}

	public void setMonday(Monday monday) {
		this.monday = monday;
	}

	public Tuesday getTuesday() {
		return tuesday;
	}

	public void setTuesday(Tuesday tuesday) {
		this.tuesday = tuesday;
	}

	public Wednesday getWednesday() {
		return wednesday;
	}

	public void setWednesday(Wednesday wednesday) {
		this.wednesday = wednesday;
	}

	public Thursday getThursday() {
		return thursday;
	}

	public void setThursday(Thursday thursday) {
		this.thursday = thursday;
	}

	public Friday getFriday() {
		return friday;
	}

	public void setFriday(Friday friday) {
		this.friday = friday;
	}

	public Saturday getSaturday() {
		return saturday;
	}

	public void setSaturday(Saturday saturday) {
		this.saturday = saturday;
	}

	public ShiftEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}

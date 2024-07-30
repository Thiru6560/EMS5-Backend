package com.shift.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shift.Entity.ShiftEntity;
import com.shift.Repository.ShiftRepo;
import com.shift.Service.ShiftService;

import jakarta.transaction.Transactional;

@Service
public class ShiftServImpl implements ShiftService {

	@Autowired
	private ShiftRepo repo;

	@Override
	public String addshift(ShiftEntity entity) {

		Optional<ShiftEntity> shift = repo.findByShiftName(entity.getShiftName());
		if (shift.isPresent())

			return "shift with name is already is present";

		{

			if (entity.getAddPaidLeaveonExtraDay() == null) {
				entity.setAddPaidLeaveonExtraDay("noo");
			}
			if (entity.getAllowShortLeave() == null) {
				entity.setAllowShortLeave("noo");
			}
			if (entity.getApplyHalfDayifLateInLimitExceeded() == null) {
				entity.setApplyHalfDayifLateInLimitExceeded("noo");
			}
			if (entity.getApplyLeaveOnHoliday() == null)
				
			{
				entity.setApplyLeaveOnHoliday("noo");
			}
			if (entity.getApplyLeaveOnWeekOff() == null) {
				entity.setApplyLeaveOnWeekOff("noo");
			}
			if (entity.getApplySandwichLeave() == null) {
				entity.setApplySandwichLeave("noo");
			}
			if (entity.getHasAlternateWeekOff() == null) {
				entity.setHasAlternateWeekOff("noo");
			}
			if (entity.getHasAutoWeekOff() == null) {
				entity.setHasAutoWeekOff("noo");
			}
			if (entity.getLateInEarlyOutApplyOnExtraDay() == null) {
				entity.setLateInEarlyOutApplyOnExtraDay("noo");
			}
			if (entity.getMaximumEarlyOut() == null) {
				entity.setMaximumEarlyOut(2);
			}
			if (entity.getMaximumLateIn() == null) {
				entity.setMaximumLateIn(2);
			}
			if (entity.getMultiplePunchInOutAllow() == null) {
				entity.setMultiplePunchInOutAllow("noo");
			}
			if (entity.getReasonOfEarlyOut() == null) {
				entity.setReasonOfEarlyOut("noo");
			}
			if (entity.getShiftName() == null) {
				entity.setShiftName("newshift");
			}
			if (entity.getTakeBreakSettings() == null) {
				entity.setTakeBreakSettings("noo");
			}
			if (entity.getWeekOffDays() == null) {
				entity.setWeekOffDays(4);
			}
			if (entity.getReasonOfLateIn() == null) {
				entity.setReasonOfLateIn("meeting");
			}
			if (entity.getRequiredOutOfRangeReason() == null) {
				entity.setRequiredOutOfRangeReason("ofyc_lunch");
			}

			repo.save(entity);

		}
		repo.save(entity);

		return "shift saved";

	}

	@Override
	public List<ShiftEntity> getall() {
		return repo.findAll();

	}

	@Override
	public ShiftEntity showbyid(String shiftid) {
		Optional<ShiftEntity> optionalEmplyoee = repo.findByShiftId(shiftid);
		return optionalEmplyoee.orElse(null); // return null if not found, handle accordingly in your application
	}

	@Transactional
	@Override
	public String deleteByShiftid(String shiftid) {

		if (repo.existsByShiftId(shiftid)) {
			
			Optional<ShiftEntity> fbs = repo.findByShiftId(shiftid);
			
			String sname= fbs.get().getShiftName();
			repo.deleteByShiftId(shiftid);

			return sname+"Shift Deleted Successfully!";
		} else {
			return "Shift Not Found with ID: "+shiftid;
		}
	}

	@Override
	public String updateshift(String param, ShiftEntity entity) {

		Optional<ShiftEntity> id = repo.findByShiftId(param);
		Optional<ShiftEntity> name = repo.findByShiftName(param);

		if (id.isPresent()) {

			System.out.println(id.get().getShiftName());
			return updateByShiftId(entity);
		}

		else {

			if (name.isPresent())

			{
				return updateByShiftName(entity);
			}

			else {
				return "Invalid parameter: " + param;
			}

		}

	}

	private String updateByShiftId(ShiftEntity entity) {

		Optional<ShiftEntity> optionalShift = repo.findByShiftId(entity.getShiftId());
		if (optionalShift.isPresent()) {

			ShiftEntity existingShift = optionalShift.get();
			// Update existing shift with new data

			if (entity.getApplySandwichLeave() != null)

				existingShift.setApplySandwichLeave(entity.getApplySandwichLeave());

			if (entity.getHasAutoWeekOff() != null)
				existingShift.setHasAutoWeekOff(entity.getHasAutoWeekOff());

			if (entity.getAllowShortLeave() != null)
				existingShift.setAllowShortLeave(entity.getAllowShortLeave());

			if (entity.getApplyHalfDayifLateInLimitExceeded() != null) {
				existingShift.setApplyHalfDayifLateInLimitExceeded(entity.getApplyHalfDayifLateInLimitExceeded());
			}

			if (entity.getHasAlternateWeekOff() != null)
				existingShift.setHasAlternateWeekOff(entity.getHasAlternateWeekOff());

			if (entity.getHasAutoWeekOff() != null)
				existingShift.setHasAutoWeekOff(entity.getHasAutoWeekOff());

			if (entity.getLateInEarlyOutApplyOnExtraDay() != null)
				existingShift.setLateInEarlyOutApplyOnExtraDay(entity.getLateInEarlyOutApplyOnExtraDay());

			if (entity.getMaximumEarlyOut() != null)

				existingShift.setMaximumEarlyOut(entity.getMaximumEarlyOut());
			if (entity.getMaximumLateIn() != null)
				existingShift.setMaximumLateIn(entity.getMaximumLateIn());
			if (entity.getMultiplePunchInOutAllow() != null)
				existingShift.setMultiplePunchInOutAllow(entity.getMultiplePunchInOutAllow());
			if (entity.getReasonOfEarlyOut() != null)
				existingShift.setReasonOfEarlyOut(entity.getReasonOfEarlyOut());
			if (entity.getReasonOfLateIn() != null)
				existingShift.setReasonOfLateIn(entity.getReasonOfLateIn());
			if (entity.getRequiredOutOfRangeReason() != null)
				existingShift.setRequiredOutOfRangeReason(entity.getRequiredOutOfRangeReason());
			if (entity.getTakeBreakSettings() != null)
				existingShift.setTakeBreakSettings(entity.getTakeBreakSettings());
			if (entity.getWeekOffDays() != null)
				existingShift.setWeekOffDays(entity.getWeekOffDays());
			if (entity.getAddPaidLeaveonExtraDay() != null)
				existingShift.setAddPaidLeaveonExtraDay(entity.getAddPaidLeaveonExtraDay());

			repo.save(existingShift);

			return "Shift updated successfully." + entity.getShiftId();
		} else {

			return "Shift with ID not found and name of the shitf" + entity.getShiftId();
		}
	}

	// @Transactional
	private String updateByShiftName(ShiftEntity entity) {

		Optional<ShiftEntity> optionalShift = repo.findByShiftName(entity.getShiftName());
		if (optionalShift.isPresent()) {

			ShiftEntity existingshift = optionalShift.get();

			if (entity.getApplySandwichLeave() != null)

				existingshift.setApplySandwichLeave(entity.getApplySandwichLeave());

			if (entity.getHasAutoWeekOff() != null)
				existingshift.setHasAutoWeekOff(entity.getHasAutoWeekOff());

			if (entity.getAllowShortLeave() != null)
				existingshift.setAllowShortLeave(entity.getAllowShortLeave());

			if (entity.getApplyHalfDayifLateInLimitExceeded() != null) {
				existingshift.setApplyHalfDayifLateInLimitExceeded(entity.getApplyHalfDayifLateInLimitExceeded());
			}

			if (entity.getHasAlternateWeekOff() != null)
				existingshift.setHasAlternateWeekOff(entity.getHasAlternateWeekOff());

			if (entity.getHasAutoWeekOff() != null)
				existingshift.setHasAutoWeekOff(entity.getHasAutoWeekOff());

			if (entity.getLateInEarlyOutApplyOnExtraDay() != null)
				existingshift.setLateInEarlyOutApplyOnExtraDay(entity.getLateInEarlyOutApplyOnExtraDay());

			if (entity.getMaximumEarlyOut() != null)
				existingshift.setMaximumEarlyOut(entity.getMaximumEarlyOut());
			if (entity.getMaximumLateIn() != null)
				existingshift.setMaximumLateIn(entity.getMaximumLateIn());
			if (entity.getMultiplePunchInOutAllow() != null)
				existingshift.setMultiplePunchInOutAllow(entity.getMultiplePunchInOutAllow());
			if (entity.getReasonOfEarlyOut() != null)
				existingshift.setReasonOfEarlyOut(entity.getReasonOfEarlyOut());
			if (entity.getReasonOfLateIn() != null)
				existingshift.setReasonOfLateIn(entity.getReasonOfLateIn());
			if (entity.getRequiredOutOfRangeReason() != null)
				existingshift.setRequiredOutOfRangeReason(entity.getRequiredOutOfRangeReason());
			if (entity.getTakeBreakSettings() != null)
				existingshift.setTakeBreakSettings(entity.getTakeBreakSettings());
			if (entity.getWeekOffDays() != null)
				existingshift.setWeekOffDays(entity.getWeekOffDays());
			if (entity.getAddPaidLeaveonExtraDay() != null)
				existingshift.setAddPaidLeaveonExtraDay(entity.getAddPaidLeaveonExtraDay());

			repo.save(existingshift);

			return "Shift updated successfully." + entity.getShiftName();
		} else {
			// Shift with given name not found
			return "Shift with name not found: " + entity.getShiftName();
		}
	}

}
package com.ems.service;

import java.util.List;

import com.ems.dto.HolidayDto;
import com.ems.entity.HolidayEntity;

public interface HolidayService {
	public String saveHoliday(HolidayDto Holiday);
	
	public HolidayEntity updateHoliday(HolidayEntity  Integer);
	
	public HolidayEntity getHolidayById(Integer HolidayId);

	public List<HolidayEntity> getAllHolidays();

	public String deleteHolidayById(Integer HolidayId);

	public Object saveHoliday(HolidayService holidayService);


	
	
	
}



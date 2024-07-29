package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.HolidayDto;
import com.ems.entity.HolidayEntity;
import com.ems.repository.HolidayRepository;
import com.ems.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;
	

	@Override
	public HolidayEntity updateHoliday(HolidayEntity holiday) {
		return holidayRepository.save(holiday);
	}

	@Override
	public HolidayEntity getHolidayById(Integer holidayId) {
		return holidayRepository.findById(holidayId).orElseThrow();
	}

	@Override
	public List<HolidayEntity> getAllHolidays() {
		return holidayRepository.findAll();
	}

	@Override
	public String deleteHolidayById(Integer holidayId) {
		holidayRepository.deleteById(holidayId);
		return "Holiday with id " + holidayId + " deleted successfully";
	}

	@Override
	public String saveHoliday(HolidayDto holiday) {

		HolidayEntity byDate = holidayRepository.findByDate(holiday.getDate());

		if (byDate != null) {

			return "Already Exists";
		} else {

			HolidayEntity he = new HolidayEntity();

			BeanUtils.copyProperties(holiday, he);
			
			holidayRepository.save(he);

			return "Created";
		}
	}

	@Override
	public Object saveHoliday(HolidayService holidayService) {
		// TODO Auto-generated method stub
		return null;
	}

}

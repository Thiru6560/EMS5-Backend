package com.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.HolidayDto;
import com.ems.entity.HolidayEntity;
import com.ems.service.HolidayService;
@RequestMapping
@RestController
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@PostMapping("/saveholidays")
	public ResponseEntity<Map<String, Object>> saveHoliday(@RequestBody HolidayDto holiday, HolidayDto holidayDto) {
		@SuppressWarnings("unused")
		String savedHoliday = holidayService.saveHoliday(holiday);

		
		Map<String, Object> response = new HashMap<>();
		response.put("message", "Holiday Created");
		response.put("holiday", holidayService.saveHoliday(holidayDto));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@PutMapping("/updateholidays")
	public ResponseEntity<Map<String, Object>> updateHoliday(@RequestBody HolidayEntity holiday) {
		@SuppressWarnings("unused")
		HolidayEntity updatedHoliday = holidayService.updateHoliday(holiday);
		
		Map<String, Object> response = new HashMap<>();
		response.put("message", "Holiday Updated");
		response.put("holiday", holidayService.updateHoliday(holiday));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getholidays/{id}")
	public ResponseEntity<HolidayEntity> getHolidayById(@PathVariable Integer id) {
		HolidayEntity holiday = holidayService.getHolidayById(id);
		return new ResponseEntity<>(holiday, HttpStatus.OK);
	}

	@GetMapping("/getallholidays")
	public ResponseEntity<List<HolidayEntity>> getAllHolidays() {
		List<HolidayEntity> holidays = holidayService.getAllHolidays();
		return new ResponseEntity<>(holidays, HttpStatus.OK);
	}

	@DeleteMapping("/deleteholidays/{id}")
	public ResponseEntity<String> deleteHolidayById(@PathVariable Integer id) {
		String message = holidayService.deleteHolidayById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}

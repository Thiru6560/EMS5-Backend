package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.AttendanceEntity;

import com.ems.service.AttendanceService;
@RestController
public class AttendanceController {

	
	@Autowired
	private AttendanceService Service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> SaveAttendanceData(@RequestBody AttendanceEntity entity){
		Boolean Status = Service.saveAttendance(entity);
		if(Status) {
			return new ResponseEntity<String>("Attendance saved successfully",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Attendance not save successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
	@GetMapping("/getattendance")
	public ResponseEntity<List<AttendanceEntity>>getAllAttendance(){
		List<AttendanceEntity> allattendance = Service.getAllattendance();
		return new ResponseEntity<List<AttendanceEntity>>(allattendance,HttpStatus.OK);

	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable Long id){
		Optional<AttendanceEntity> attendance = Service.getAttendanceById(id);
		return attendance.map(entity -> new ResponseEntity<>(entity,HttpStatus.OK))
	                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}

package com.ems.service;

import java.util.List;
import java.util.Optional;

import com.ems.entity.AttendanceEntity;



public interface AttendanceService {

	public Boolean saveAttendance(AttendanceEntity entity);
    
	public List<AttendanceEntity> getAllattendance();
	
	Optional<AttendanceEntity> getAttendanceById(Long id);
	

	
	
	
}

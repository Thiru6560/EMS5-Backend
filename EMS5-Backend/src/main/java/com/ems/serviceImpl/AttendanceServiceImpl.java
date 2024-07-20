package com.ems.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.AttendanceEntity;

import com.ems.repository.AttendanceRepository;
import com.ems.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attendancerepo;

	
	@Override
	public Boolean saveAttendance(AttendanceEntity entity) {
		attendancerepo.save(entity);
		return true;
	}


	@Override
	public List<AttendanceEntity> getAllattendance() {
		
		return attendancerepo.findAll();
	}


	@Override
	public Optional<AttendanceEntity> getAttendanceById(Long id) {
		return attendancerepo.findById(id);
		
	}

}


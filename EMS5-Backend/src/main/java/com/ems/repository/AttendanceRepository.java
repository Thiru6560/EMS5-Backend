package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.AttendanceEntity;

public interface AttendanceRepository  extends JpaRepository<AttendanceEntity,Long>{

}

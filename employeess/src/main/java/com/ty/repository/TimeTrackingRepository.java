package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.timetracking.TimeTracking;

public interface TimeTrackingRepository extends JpaRepository<TimeTracking, Long> {
  
}

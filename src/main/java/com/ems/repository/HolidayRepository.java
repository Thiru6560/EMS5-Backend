package com.ems.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.HolidayEntity;

public interface HolidayRepository extends JpaRepository<HolidayEntity, Integer> {

	HolidayEntity findByDate(LocalDate date);

}

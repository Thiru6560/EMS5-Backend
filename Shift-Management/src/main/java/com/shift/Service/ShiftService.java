package com.shift.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shift.Entity.ShiftEntity;

@Service
public interface ShiftService {

	public String addshift(ShiftEntity entity);

	public List<ShiftEntity> getall();

	public ShiftEntity showbyid(String shiftid);

	public String updateshift(String param, ShiftEntity entity);

	public String deleteByShiftid(String shiftid);

}

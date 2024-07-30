package com.shift.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.ShiftEntity;

@Repository
public interface ShiftRepo extends JpaRepository<ShiftEntity, String> {
	Optional<ShiftEntity> findByShiftName(String shiftName);

	Optional<ShiftEntity> findByShiftId(String shiftid);

	public String deleteByShiftId(String shiftid);

	public boolean existsByShiftId(String shiftid);

}

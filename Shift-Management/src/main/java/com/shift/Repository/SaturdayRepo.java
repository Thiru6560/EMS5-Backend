package com.shift.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.Saturday;

@Repository
public interface SaturdayRepo extends JpaRepository<Saturday, Long> {

}

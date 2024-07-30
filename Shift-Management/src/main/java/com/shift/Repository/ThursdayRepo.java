package com.shift.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.Thursday;

@Repository
public interface ThursdayRepo  extends JpaRepository<Thursday, Long>{

}

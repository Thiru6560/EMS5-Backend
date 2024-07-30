package com.shift.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.Monday;

@Repository
public interface MondayRepo extends JpaRepository<Monday,Long> {

}

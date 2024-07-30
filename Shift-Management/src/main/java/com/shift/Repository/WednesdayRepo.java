package com.shift.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.Wednesday;

@Repository
public interface WednesdayRepo extends JpaRepository<Wednesday,Long> {

}

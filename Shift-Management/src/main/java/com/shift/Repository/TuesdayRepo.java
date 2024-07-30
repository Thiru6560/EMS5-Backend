package com.shift.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.Tuesday;

@Repository
public interface TuesdayRepo extends JpaRepository<Tuesday, Long> {

}

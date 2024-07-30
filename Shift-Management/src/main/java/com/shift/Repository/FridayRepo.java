package com.shift.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shift.Entity.Friday;

@Repository
public interface FridayRepo extends JpaRepository<Friday, Long> {

}

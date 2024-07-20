package com.ems.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ems.entity.ProductiveEntity;

import com.ems.service.ProductiveService;

@RestController
public class ProductiveController {
	
	@Autowired
	private ProductiveService Service;
	
	
	@PostMapping("/saveProductive")
	public ResponseEntity<String> SaveProductiveData(@RequestBody ProductiveEntity entity){
		Boolean Status = Service.saveProductive(entity);
		if(Status) {
			return new ResponseEntity<String>("Productive saved successfully",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Productive not save successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<ProductiveEntity>>getAllProductive(){
		List<ProductiveEntity> allproductive = Service.getAllProductive();
		return new ResponseEntity<List<ProductiveEntity>>(allproductive,HttpStatus.OK);

	}
	
	@GetMapping("/getProductiveById/{id}")
	public ResponseEntity<ProductiveEntity> getProductiveById(@PathVariable Long id){
		Optional<ProductiveEntity> productive = Service.getProductiveById(id);
		return productive.map(entity -> new ResponseEntity<>(entity,HttpStatus.OK))
	                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}

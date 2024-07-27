package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.serviceImpl.LocationFindServImpl;

@RestController
@CrossOrigin(origins = "*")
public class LocationFindController {

	@Autowired
	private LocationFindServImpl locationFindService;

	@GetMapping("/locationFind")
	public ResponseEntity<?> geocode(@RequestParam String address) {

		if (locationFindService.geocodeAddress(address) != null) {

			return new ResponseEntity<>(locationFindService.geocodeAddress(address), HttpStatus.OK);
		}
		return new ResponseEntity<>("Not Found", HttpStatus.NO_CONTENT);
	}

}

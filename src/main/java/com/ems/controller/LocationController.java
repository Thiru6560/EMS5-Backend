package com.ems.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDTO;
import com.ems.dto.LatLon;
import com.ems.entity.Employee;
import com.ems.exceptions.BadRequestException;
import com.ems.exceptions.UnauthorizedException;
import com.ems.service.LocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/location")
public class LocationController {

	@Autowired
	private LocationService employeeService;

	@GetMapping("/checkLocation")
	public ResponseEntity<Map<String, Object>> checkLocation(@RequestParam Long id, @RequestBody LatLon latlon, BindingResult bindingResult) {

		Map<String, Object> response = new HashMap<>();
		if(bindingResult.hasErrors()) {
		response.put("error", "ERRORS");	
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		
		
		response.put("message", "Location Matched");
		response.put("type", employeeService.checkLocation(id, latlon));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/saveLocation")
	public ResponseEntity<Map<String, Object>> saveEmployeeLocation(@Valid @RequestBody EmployeeDTO employeeDTO) {

 		Map<String, Object> response = new HashMap<>();
		response.put("message", "Location Saved");
		response.put("employee", employeeService.saveEmployeeLocation(employeeDTO));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/updateHomeLocation")
	public ResponseEntity<Map<String, Object>> updateHomeLocation(@RequestParam Long adminId,
			@RequestParam Long employeeId, @RequestBody LatLon latlon) {

		Employee adminById = employeeService.getEmployeeById(adminId);

		if (!adminById.getRole().toLowerCase().equals("admin")) {

			throw new UnauthorizedException("Only Admin can Change Location");
		}

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Home Location Updated");
		response.put("employee", employeeService.updateHomeLocation(employeeId, latlon));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("/updateOfficeLocation")
	public ResponseEntity<Map<String, Object>> updateOfficeLocation(@RequestParam Long adminId,
			@RequestParam Long employeeId, @RequestBody LatLon latlon) {

		Employee adminById = employeeService.getEmployeeById(adminId);

		if (!adminById.getRole().toLowerCase().equals("admin")) {

			throw new UnauthorizedException("Only Admin can Change Location");
		}

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Office Location Updated");
		response.put("employee", employeeService.updateOfficeLocation(employeeId, latlon));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/deleteHomeLocation")
	public ResponseEntity<Map<String, Object>> deleteHomeLocation(@RequestParam Long adminId,
			@RequestParam Long employeeId) {

		if (adminId.equals(null) || employeeId.equals(null)) {

			throw new BadRequestException("Please Enter Correct Data");
		}

		Employee adminById = employeeService.getEmployeeById(adminId);

		if (!adminById.getRole().toLowerCase().equals("admin")) {

			throw new UnauthorizedException("Only Admin can Delete Location");
		}

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Home Location Deleted");
		response.put("employee", employeeService.deleteHomeLocation(employeeId));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@DeleteMapping("/deleteOfficeLocation")
	public ResponseEntity<Map<String, Object>> deleteOfficeLocation(@RequestParam Long adminId,
			@RequestParam Long employeeId) {

		if (adminId.equals(null) || employeeId.equals(null)) {

			throw new BadRequestException("Please Enter Correct Data");
		}

		Employee adminById = employeeService.getEmployeeById(adminId);

		if (!adminById.getRole().toLowerCase().equals("admin")) {

			throw new UnauthorizedException("Only Admin can Delete Location");
		}

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Office Location Deleted");
		response.put("employee", employeeService.deleteOfficeLocation(employeeId));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees() {

		return new ResponseEntity<>(employeeService.getAllLocations(), HttpStatus.OK);
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<Map<String, Object>> getEmployee(@RequestParam Long id) {

		Map<String, Object> response = new HashMap<>();
		response.put("message", "employee with ID - " + id);
		response.put("employee", employeeService.getEmployeeById(id));

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/getAllLocations")
	public ResponseEntity<Map<String, Object>> getAllLocation() {
		Map<String, Object> response = new HashMap<>();
		response.put("message", "All Locations");
		response.put("locations", employeeService.getAllLocations());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

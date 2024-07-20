package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;
import com.ems.service.EmployeeService;


@RestController
public class EmployeeController {

	
	@Autowired
    private EmployeeService employeeService;

    @PostMapping("/location")
    public ResponseEntity<Employee> login(@RequestBody EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeService.getEmployeeByName(employeeDTO.getName());
        
        if (existingEmployee != null) {
            
            Employee updateEmployee = employeeService.saveEmployee(employeeDTO);
        	
            employeeService.saveEmployeeLocation(updateEmployee);
            return ResponseEntity.ok(updateEmployee);
        } else {

        	Employee newEmployee = new Employee();
        	Employee saveEmployee = employeeService.saveEmployee(employeeDTO);
            employeeService.saveEmployeeLocation(saveEmployee);
            return ResponseEntity.ok(saveEmployee);
        }
    }
}

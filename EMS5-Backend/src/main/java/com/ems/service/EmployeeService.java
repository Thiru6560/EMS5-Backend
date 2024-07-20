package com.ems.service;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;

@Service
public interface EmployeeService {

	public Employee saveEmployeeLocation(Employee employee);

	public Employee getEmployeeByName(String name);

	public Employee saveEmployee(EmployeeDTO employeeDTO);
}

package com.ems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDTO;
import com.ems.entity.Employee;
import com.ems.entity.Location;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployeeLocation(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	 public Employee saveEmployee(EmployeeDTO employeeDTO) {
	        Employee employee = new Employee();
	        employee.setName(employeeDTO.getName());

	        Location homeLocation = new Location();
	        homeLocation.setLatitude(employeeDTO.getHomeLocation().getLatitude());
	        homeLocation.setLongitude(employeeDTO.getHomeLocation().getLongitude());
	        employee.setHomeLocation(homeLocation);

	        Location officeLocation = new Location();
	        officeLocation.setLatitude(employeeDTO.getOfficeLocation().getLatitude());
	        officeLocation.setLongitude(employeeDTO.getOfficeLocation().getLongitude());
	        employee.setOfficeLocation(officeLocation);

	        return employee;
	    }
}

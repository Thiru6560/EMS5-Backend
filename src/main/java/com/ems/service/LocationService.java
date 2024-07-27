package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDTO;
import com.ems.dto.LatLon;
import com.ems.entity.Employee;
import com.ems.entity.Location;

@Service
public interface LocationService {

	public String checkLocation(Long id,LatLon latlon);
	
	public EmployeeDTO saveEmployeeLocation(EmployeeDTO employeeDto);

	public EmployeeDTO updateHomeLocation(Long id,LatLon latlng);

	public EmployeeDTO updateOfficeLocation(Long id,LatLon latlng);

	public EmployeeDTO deleteHomeLocation(Long id);

	public EmployeeDTO deleteOfficeLocation(Long id);

	public EmployeeDTO getEmployeeByName(String name);
	
	public Employee getEmployeeById(Long id);

	public Employee convertDtotoDao(EmployeeDTO employeeDTO);

	public EmployeeDTO convertDaotoDto(Employee employee);

	public List<EmployeeDTO> getAllEmployees();

	public List<Location> getAllLocations();
}

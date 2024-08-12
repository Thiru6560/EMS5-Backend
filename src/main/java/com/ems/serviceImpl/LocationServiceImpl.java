package com.ems.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dto.EmployeeDTO;
import com.ems.dto.LatLon;
import com.ems.dto.LocationDTO;
import com.ems.entity.Employee;
import com.ems.entity.Location;
import com.ems.exceptions.DuplicateDataException;
import com.ems.exceptions.EmptyFieldException;
import com.ems.exceptions.NoLocationFoundException;
import com.ems.exceptions.NoSuchUserException;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.LocationRepository;
import com.ems.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LocationRepository locationRepository;

	

	@Transactional
	public EmployeeDTO assignShift(Long employeeId, String shiftId) {
		
		Employee employeeById = getEmployeeById(employeeId);
		
		employeeById.setShiftId(shiftId);
		
		return convertDaotoDto(employeeById);
	}
	
	public String checkLocation(Long id, LatLon latlon) {

	    Employee employeeById = getEmployeeById(id);
	    Location location = employeeById.getLocation();

	    if (location == null) {
	        throw new EmptyFieldException("Location data is missing for the employee");
	    }

	    boolean officeLocationMissing = location.getOfficeLatitude() == null || location.getOfficeLongitude() == null;
	    boolean homeLocationMissing = location.getHomeLatitude() == null || location.getHomeLongitude() == null;

	    if (officeLocationMissing && homeLocationMissing) {
	        throw new EmptyFieldException("Both Office and Home Locations are Empty");
	    }

	    if (location.getOfficeLatitude() != null && location.getOfficeLongitude() != null &&
	        location.getOfficeLatitude().equals(latlon.getLat()) &&
	        location.getOfficeLongitude().equals(latlon.getLon())) {
	        return "OFFICE";
	    }

	    if (location.getHomeLatitude() != null && location.getHomeLongitude() != null &&
	        location.getHomeLatitude().equals(latlon.getLat()) &&
	        location.getHomeLongitude().equals(latlon.getLon())) {
	        return "HOME";
	    }

	    throw new NoLocationFoundException("Location Not Matched");
	}


	public EmployeeDTO saveEmployeeLocation(EmployeeDTO employeeDTO) {

		Employee byName = employeeRepository.findByName(employeeDTO.getName());
		if (byName != null) {
			throw new DuplicateDataException("user Already Exists");
		}

		Employee employee = convertDtotoDao(employeeDTO);
		Employee savedEmployee = employeeRepository.save(employee);

		return convertDaotoDto(savedEmployee);
	}

	@Transactional
	public EmployeeDTO updateHomeLocation(Long id, LatLon latlon) {

		Employee byId = getEmployeeById(id);

		Location location = byId.getLocation();
		location.setHomeLatitude(latlon.getLat());
		location.setHomeLongitude(latlon.getLon());

		return convertDaotoDto(byId);

	}

	@Transactional
	public EmployeeDTO updateOfficeLocation(Long id, LatLon latlon) {
		Employee byId = getEmployeeById(id);

		Location location = byId.getLocation();
		location.setOfficeLatitude(latlon.getLat());
		location.setOfficeLongitude(latlon.getLon());

		return convertDaotoDto(byId);

	}

	@Transactional
	public EmployeeDTO deleteHomeLocation(Long id) {
		Employee byId = getEmployeeById(id);

		Location location = byId.getLocation();
		location.setHomeLatitude(null);
		location.setHomeLongitude(null);

		return convertDaotoDto(byId);

	}

	@Transactional
	public EmployeeDTO deleteOfficeLocation(Long id) {
		Employee byId = getEmployeeById(id);

		Location location = byId.getLocation();
		location.setOfficeLatitude(null);
		location.setOfficeLongitude(null);

		return convertDaotoDto(byId);

	}

	public EmployeeDTO getEmployeeByName(String name) {
		System.out.println("-------");
		return convertDaotoDto(employeeRepository.findByName(name));
	}

	public Employee getEmployeeById(Long id) {

		Optional<Employee> byId = employeeRepository.findById(id);

		if (byId.isEmpty()) {
			throw new NoSuchUserException("No User Found With ID - " + id);
		}

		return byId.get();
	}

	public EmployeeDTO getEmployeeByIds(Long id) {
		Optional<Employee> byId = employeeRepository.findById(id);

		if (byId.isEmpty()) {
			throw new NoSuchUserException("No User Found With ID - " + id);
		}

		return convertDaotoDto(byId.get());
	}

	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> all = employeeRepository.findAll();
		List<EmployeeDTO> allLoc = new ArrayList<>();
		for (Employee e : all) {
			System.out.println(e);

			allLoc.add(convertDaotoDto(e));
		}
		return allLoc;
	}

	@Override
	public List<Location> getAllLocations() {

		return locationRepository.findAll();
	}

	public Employee convertDtotoDao(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setName(employeeDTO.getName());

		System.out.println(employeeDTO.getName());
		employee.setRole(employeeDTO.getRole());

		Location location = new Location();
		location.setHomeLatitude(Double.parseDouble(employeeDTO.getHomeLocation().getLatitude()));
		location.setHomeLongitude(Double.parseDouble(employeeDTO.getHomeLocation().getLongitude()));

		location.setOfficeLatitude(Double.parseDouble(employeeDTO.getOfficeLocation().getLatitude()));
		location.setOfficeLongitude(Double.parseDouble(employeeDTO.getOfficeLocation().getLongitude()));

		employee.setLocation(location);

		return employee;
	}

	public EmployeeDTO convertDaotoDto(Employee employee) {

		EmployeeDTO employeeDto = new EmployeeDTO();

		employeeDto.setName(employee.getName());
		employeeDto.setRole(employee.getRole());
		LocationDTO home = new LocationDTO();
		home.setLatitude(employee.getLocation().getHomeLatitude()!=null?employee.getLocation().getHomeLatitude().toString():"This Field is Empty");
		home.setLongitude(employee.getLocation().getHomeLongitude()!=null?employee.getLocation().getHomeLongitude().toString():"This Field is Empty");
		home.setType("HOME");

		LocationDTO office = new LocationDTO();
		office.setLatitude(employee.getLocation().getOfficeLatitude()!=null?employee.getLocation().getOfficeLatitude().toString():"This Field is Empty");
		office.setLongitude(employee.getLocation().getOfficeLongitude()!=null?employee.getLocation().getOfficeLongitude().toString():"This Field is Empty");
		office.setType("OFFICE");
		employeeDto.setHomeLocation(home);
		employeeDto.setOfficeLocation(office);

		return employeeDto;
	}

}

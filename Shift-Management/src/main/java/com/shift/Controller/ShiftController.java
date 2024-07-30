package com.shift.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shift.Entity.ShiftEntity;
import com.shift.Service.ShiftService;

@RestController
@CrossOrigin(origins = "*")
public class ShiftController {

	@Autowired
	private ShiftService serv;

	@PostMapping("/add" )
	public ResponseEntity<String> addshift(@RequestBody ShiftEntity entity) {
		String result = serv.addshift(entity);

		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}

	@GetMapping("/showAll")
	public ResponseEntity<List<ShiftEntity>> getUser() {
		List<ShiftEntity> emp = serv.getall();
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping("/show/{shiftid}")
	public ShiftEntity getbyid(@PathVariable String shiftid) {
		// serv.showbyid(shiftid);
		return serv.showbyid(shiftid);
	}

	@PutMapping("/update/{param}")
	public ResponseEntity<String> updateshift(@PathVariable String param, @RequestBody ShiftEntity entity) {
		String result = serv.updateshift(param, entity);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	// @Transactional
	@DeleteMapping("/delete/{shiftid}")
	public String deleteshift(@PathVariable String shiftid) {
		return serv.deleteByShiftid(shiftid);
	}

}

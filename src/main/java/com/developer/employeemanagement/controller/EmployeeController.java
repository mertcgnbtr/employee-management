package com.developer.employeemanagement.controller;

import java.util.Date;
import java.util.List;

import com.developer.employeemanagement.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.developer.employeemanagement.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping
	public List<Employee> findAllEmployee(){
		return employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") String id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@GetMapping("/by-name")
	public ResponseEntity<List<Employee>> findByName(@RequestParam String name){
		return ResponseEntity.ok(employeeService.findByName(name));
	}

	@GetMapping("/date-range")
	public ResponseEntity<List<Employee>> getEmployeesByDateRange(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return ResponseEntity.ok(employeeService.getEmployeesByDateRange(startDate, endDate));
	}
	
	@PostMapping
	public ResponseEntity save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Employee employee) {
		employeeService.update(employee);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/letters")
	public ResponseEntity<List<Employee>> getEmployeesByLetters(@RequestParam("letters") String letters){
		return ResponseEntity.ok(employeeService.getEmployeesByLetters(letters));
	}

}

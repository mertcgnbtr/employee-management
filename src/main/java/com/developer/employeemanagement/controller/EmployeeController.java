package com.developer.employeemanagement.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.developer.employeemanagement.service.impl.EmployeeService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
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
	public Optional<Employee> findEmployeeById(@PathVariable("id") Long id) {
		return employeeService.findById(id);
	}

	@GetMapping("/by-name")
	public List<Employee> findByName(@RequestParam String name){
		return employeeService.findByName(name);
	}

	@GetMapping("/date-range")
	public List<Employee> getEmployeesByDateRange(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

		return employeeService.getEmployeesByDateRange(startDate, endDate);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
	}

}

package com.developer.employeemanagement.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.employeemanagement.entity.Employee;
import com.developer.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public List<Employee> getEmployeesByDateRange(Date startDate, Date endDate) {
		return employeeRepository.findByDateOfBirthBetween(startDate, endDate);
	}

	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}

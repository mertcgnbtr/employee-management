package com.developer.employeemanagement.service;

import java.util.Date;
import java.util.List;

import com.developer.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import com.developer.employeemanagement.entity.Employee;

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

	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.update(employee);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.delete(id);
	}

}

package com.developer.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.employeemanagement.entity.Employee;

import javax.print.DocFlavor;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByDateOfBirthBetween(Date startDate, Date endDate);
	
	
	
	

}

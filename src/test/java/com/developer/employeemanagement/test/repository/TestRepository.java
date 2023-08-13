package com.developer.employeemanagement.test.repository;

import com.developer.employeemanagement.entity.Employee;
import com.developer.employeemanagement.entity.Gender;
import com.developer.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestRepository {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testSave(){
        var employee = new Employee();
        employee.setName("John Doe");
        employee.setGender(Gender.MALE);
        employee.setDateOfBirth(new Date());
        employee.setAddress("Amerika");

        // Act
        employeeRepository.save(employee);

        // Assert
        assertNotNull(employee.getId());
    }



}

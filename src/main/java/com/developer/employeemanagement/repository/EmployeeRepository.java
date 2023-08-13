package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.Employee;
import com.developer.employeemanagement.entity.Gender;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findByName(String name){
        String sql = "SELECT * FROM mt_employee WHERE name = ?";
        return (List<Employee>) jdbcTemplate.queryForObject(sql, new Object[]{name}, this::mapRowToEmployee);
    }

    public List<Employee> findByDateOfBirthBetween(Date startDate, Date endDate) {
        String sql = "SELECT * FROM mt_employee WHERE dateOfBirth BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, this::mapRowToEmployee);
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM mt_employee";
        return jdbcTemplate.query(sql, this::mapRowToEmployee);
    }

    public Employee findById(String id) {
        String sql = "SELECT * FROM mt_employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToEmployee);
    }

    public void save(Employee employee) {
        if (employee.getId() == null){
            employee.setId(UUID.randomUUID().toString());
        }
        String sql = "INSERT INTO mt_employee (id, name, gender, date_of_birth, address) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getGender().getId(), employee.getDateOfBirth(), employee.getAddress());
    }

    public void update(Employee employee) {
        String sql = "UPDATE mt_employee SET name = ?, gender = ?, date_of_birth = ?, address = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getGender().getId(), employee.getDateOfBirth(), employee.getAddress(), employee.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM mt_employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Employee> findByLetters(String letters) {
        String query = "SELECT * FROM mt_employee WHERE name LIKE ?";
        String likeKeyword = "%" + letters + "%";

        return jdbcTemplate.query(query, new Object[]{likeKeyword}, this::mapRowToEmployee);

    }

    private Employee mapRowToEmployee(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String name = rs.getString("name");
        Gender gender = null;
        int genderId = rs.getInt("gender");
        Optional<Gender> optionalGender = Gender.findById(genderId);
        gender = optionalGender.get();
        Date dateOfBirth = rs.getDate("date_of_birth");
        String address = rs.getString("address");
        return new Employee(id, name, gender, dateOfBirth, address);
    }


}

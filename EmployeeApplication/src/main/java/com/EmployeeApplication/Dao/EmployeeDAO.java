package com.EmployeeApplication.Dao;

import com.EmployeeApplication.Model.EmployeeModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert a new employee
    public int save(EmployeeModel emp) {
        String sql = "INSERT INTO employee (name, department_id, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, emp.getName(), emp.getDepartmentId(), emp.getSalary());
    }

    // Update existing employee
    public int update(EmployeeModel emp) {
        String sql = "UPDATE employee SET name=?, department_id=?, salary=? WHERE emp_id=?";
        return jdbcTemplate.update(sql, emp.getName(), emp.getDepartmentId(), emp.getSalary(), emp.getId());
    }

    // Delete employee by ID
    public int delete(int empId) {
        String sql = "DELETE FROM employee WHERE emp_id=?";
        return jdbcTemplate.update(sql, empId);
    }

    // Get all employees
    public List<EmployeeModel> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new EmployeeModel(
                rs.getInt("emp_id"),
                rs.getString("name"),
                rs.getInt("department_id"),
                rs.getDouble("salary")
        ));
    }

    // Get employee by ID
    public EmployeeModel findById(int empId) {
        String sql = "SELECT * FROM employee WHERE emp_id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new EmployeeModel(
                rs.getInt("emp_id"),
                rs.getString("name"),
                rs.getInt("department_id"),
                rs.getDouble("salary")
        ), empId);
    }
}

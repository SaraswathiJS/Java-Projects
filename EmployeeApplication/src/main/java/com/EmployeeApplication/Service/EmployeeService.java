package com.EmployeeApplication.Service;

import com.EmployeeApplication.Dao.EmployeeDAO;
import com.EmployeeApplication.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
   @Autowired
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // Add new employee
    public void addEmployee(EmployeeModel emp) {
        employeeDAO.save(emp);
    }

    // Update existing employee
    public String updateEmployee(EmployeeModel emp) {
        int rows = employeeDAO.update(emp);
        if (rows == 0) {
            return "No employee found with ID: " + emp.getId();
        }
        return "Employee Updated Successfully!";
    }

    // Delete employee by ID
    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }

    // Get all employees
    public List<EmployeeModel> getAllEmployees() {
        return employeeDAO.findAll();
    }

    // Get employee by ID
    public EmployeeModel getEmployeeById(int id) {
        return employeeDAO.findById(id);
    }
}

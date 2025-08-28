package com.EmployeeApplication.Controller;

import com.EmployeeApplication.Model.EmployeeModel;
import com.EmployeeApplication.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Add new employee
    @PostMapping
    public String addEmployee(@RequestBody EmployeeModel emp) {
        employeeService.addEmployee(emp);
        return "Employee Added Successfully!";
    }

    // Update existing employee
    @PutMapping
    public String updateEmployee(@RequestBody EmployeeModel emp) {
        return employeeService.updateEmployee(emp);
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee Deleted Successfully!";
    }

    // Get all employees
    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public EmployeeModel getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
}

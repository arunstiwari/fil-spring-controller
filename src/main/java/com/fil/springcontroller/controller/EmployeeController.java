package com.fil.springcontroller.controller;

import com.fil.springcontroller.entity.Employee;
import com.fil.springcontroller.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   // /employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee fetchSpecificEmployeeRecord(@PathVariable("id") long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) {
        System.out.println("Creating new employee" + employee);
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeRecord(@PathVariable("id") long id,@RequestBody Employee employee) {
        System.out.println("Creating new employee" + employee);
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeRecord(@PathVariable("id") long id) {
        System.out.println("Deleting existing employee" );
        return employeeService.deleteEmployee(id);
    }

}

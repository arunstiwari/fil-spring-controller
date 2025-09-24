package com.fil.springcontroller.service;

import com.fil.springcontroller.entity.Employee;
import com.fil.springcontroller.repository.EmployeeRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            employeeRepository.save(existingEmployee);
            return existingEmployee;
        }
        return null;
    }

    public String deleteEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById(id);
        if (existingEmployee != null) {
            employeeRepository.findAll().remove(existingEmployee);
            return "Employee deleted successfully";
        }
        return null;
    }
}

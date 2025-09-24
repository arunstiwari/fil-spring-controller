package com.fil.springcontroller.controller;

import com.fil.springcontroller.entity.Employee;
import com.fil.springcontroller.exception.EmployeeNotFoundException;
import com.fil.springcontroller.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

//    @ExceptionHandler(EmployeeNotFoundException.class)
//    public ResponseEntity<Employee> handleEmployeeNotFoundException(){
//        System.out.println("Employee not found");
//        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   // /employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> fetchSpecificEmployeeRecord(@PathVariable("id") long id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Employee> createNewEmployee(@Valid @RequestBody Employee employee) {
        System.out.println("Creating new employee" + employee);
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeRecord(@PathVariable("id") long id,@RequestBody Employee employee) {
        System.out.println("Creating new employee" + employee);
        Employee updateEmployee = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeRecord(@PathVariable("id") long id) {
        System.out.println("Deleting existing employee" );
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }

}

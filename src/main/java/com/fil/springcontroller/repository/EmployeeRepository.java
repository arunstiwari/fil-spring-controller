package com.fil.springcontroller.repository;

import com.fil.springcontroller.entity.Employee;
import com.fil.springcontroller.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        this.employees.add(new Employee(1000l, "Arun", "IT" ));
        this.employees.add(new Employee(1001l, "Vinesh", "IT"));
        this.employees.add(new Employee(1002L, "Deepak", "HR"));
    }

    public List<Employee> findAll() {
        return this.employees;
    }

    public Employee save(Employee employee) {
        employee.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        this.employees.add(employee);
        return employee;
    }

    public Employee findById(long id){
        for (Employee employee : this.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found with id:" + id);
    }
}

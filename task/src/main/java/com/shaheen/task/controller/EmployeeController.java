package com.shaheen.task.controller;

import com.shaheen.task.common.EmployeeD;
import com.shaheen.task.entity.Employee;
import com.shaheen.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/employees")

public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public Page<Employee> getEmployees(Pageable page){
        return employeeService.getEmployees(page);
    }
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable(value = "employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @GetMapping("/similar")
    public List<Employee> getEmployeesWithSimilarName(@Param("name") String name){
        return employeeService.getEmployeesWithSimilarName(name);
    }
    @PostMapping("")
    public void addEmployee(@RequestBody EmployeeD employee){
        employeeService.addEmployee(employee);
    }
}

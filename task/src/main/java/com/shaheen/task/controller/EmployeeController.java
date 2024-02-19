package com.shaheen.task.controller;

import com.shaheen.task.entity.Employee;
import com.shaheen.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")

public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable(value = "employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
}

package com.shaheen.task.controller;

import com.shaheen.task.entity.Employee;
import com.shaheen.task.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    private final EmployeeService employeeService;

    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{departmentId}/employees")
    List<Employee> getEmployees(@PathVariable(value = "departmentId") Long departmentId){
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }
}

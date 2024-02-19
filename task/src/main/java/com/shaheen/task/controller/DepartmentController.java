package com.shaheen.task.controller;

import com.shaheen.task.entity.Employee;
import com.shaheen.task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/employees")
    Set<Employee> getEmployees(@PathVariable(value = "departmentId") Long departmentId){
        System.out.println(departmentId);
        return departmentService.getEmployeesByDepartmentId(departmentId);
    }
}

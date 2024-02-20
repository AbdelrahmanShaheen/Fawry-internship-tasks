package com.shaheen.task.service;

import com.shaheen.task.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public Employee getEmployeeById(Long id);

    public List<Employee>getEmployeesByDepartmentId(Long departmentId);
}

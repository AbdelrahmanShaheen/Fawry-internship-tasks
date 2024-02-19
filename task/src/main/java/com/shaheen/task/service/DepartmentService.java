package com.shaheen.task.service;

import com.shaheen.task.entity.Employee;

import java.util.Set;

public interface DepartmentService {
    public Set<Employee> getEmployeesByDepartmentId(Long departmentId);
}

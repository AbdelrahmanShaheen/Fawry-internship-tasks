package com.shaheen.task.dao;

import com.shaheen.task.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    public List<Employee> selectEmployees();
    public Optional<Employee> selectEmployeeById(Long id);
}

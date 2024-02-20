package com.shaheen.task.service;

import com.shaheen.task.common.EmployeeD;
import com.shaheen.task.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    public Page<Employee> getEmployees(Pageable page);

    public Employee getEmployeeById(Long id);

    public List<Employee>getEmployeesByDepartmentId(Long departmentId);

    public List<Employee>getEmployeesWithSimilarName(String name);

    public void addEmployee(EmployeeD employee);
}

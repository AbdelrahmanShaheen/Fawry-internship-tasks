package com.shaheen.task.service;

import com.shaheen.task.common.EmployeeD;
import com.shaheen.task.entity.Employee;
import com.shaheen.task.exception.ResourceNotFoundException;
import com.shaheen.task.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Page<Employee> getEmployees(Pageable page) {
        return employeeRepository.findAll(page);
    }
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("employee with id [%s] not found".formatted(id)));
    }
    @Override
    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }
    @Override
    public List<Employee> getEmployeesWithSimilarName(String name) {
        return employeeRepository.findEmployeesWithSimilarName(name);
    }
    @Override
    public void addEmployee(EmployeeD employee) {
        employeeRepository.save(employee);
    }
}

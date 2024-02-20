package com.shaheen.task.dao;

import com.shaheen.task.entity.Employee;
import com.shaheen.task.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private final EmployeeRepository employeeRepository;

    public EmployeeDaoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> selectEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> selectEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> selectEmployeeByDepartmentId(Long departmentId) {
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }
}

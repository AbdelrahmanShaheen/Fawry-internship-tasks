package com.shaheen.task.service;

import com.shaheen.task.dao.EmployeeDao;
import com.shaheen.task.entity.Employee;
import com.shaheen.task.exception.ResourceNotFoundException;
import com.shaheen.task.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;
    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.selectEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao
                .selectEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("employee with id [%s] not found".formatted(id)));
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeDao.selectEmployeeByDepartmentId(departmentId);
    }
}

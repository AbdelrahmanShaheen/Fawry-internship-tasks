package com.shaheen.task.service;

import com.shaheen.task.dao.DepartmentDao;
import com.shaheen.task.entity.Department;
import com.shaheen.task.entity.Employee;
import com.shaheen.task.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentDao departmentDao;
    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Set<Employee> getEmployeesByDepartmentId(Long departmentId) {
        Optional<Department> departmentOptional = departmentDao.selectDepartment(departmentId);
        Department department =
                    departmentOptional
                    .orElseThrow(() -> new ResourceNotFoundException("department with id [%s] not found".formatted(departmentId)));
        System.out.println(department);
        return department.getEmployees();
    }
}

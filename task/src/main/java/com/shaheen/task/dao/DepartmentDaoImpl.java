package com.shaheen.task.dao;

import com.shaheen.task.entity.Department;
import com.shaheen.task.repository.DepartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class DepartmentDaoImpl implements DepartmentDao{
    private final DepartmentRepository departmentRepository;

    public DepartmentDaoImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<Department> selectDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }
}

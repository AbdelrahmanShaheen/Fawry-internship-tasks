package com.shaheen.task.dao;

import com.shaheen.task.entity.Department;

import java.util.Optional;

public interface DepartmentDao {
    Optional<Department> selectDepartment(Long departmentId);
}

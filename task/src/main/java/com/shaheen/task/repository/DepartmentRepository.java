package com.shaheen.task.repository;

import com.shaheen.task.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department ,Long> {
}

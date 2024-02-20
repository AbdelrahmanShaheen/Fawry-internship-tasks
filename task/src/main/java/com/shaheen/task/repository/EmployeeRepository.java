package com.shaheen.task.repository;

import com.shaheen.task.common.EmployeeD;
import com.shaheen.task.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.department.departmentId = :departmentId")
    List<Employee> findEmployeesByDepartmentId(Long departmentId);

    @Override
    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.employeeName LIKE %:name%")
    List<Employee> findEmployeesWithSimilarName(String name);

    void save(EmployeeD employeeD);
}

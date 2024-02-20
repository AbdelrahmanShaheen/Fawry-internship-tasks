package com.shaheen.task.common;

import com.shaheen.task.entity.Department;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "employee")
@Entity
public class EmployeeD {
    @Id
    @Column(name = "emp_id")
    private long employeeId;
    @Column(name = "emp_name")
    private String employeeName;
    @Column(name = "emp_salary")
    private Double employeeSalary;
    @Column(name = "dept_id")
    private Long departmentId;
    public EmployeeD(){

    }

    public EmployeeD(String employeeName, Double employeeSalary, Long departmentId) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.departmentId = departmentId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeD employeeD = (EmployeeD) o;
        return employeeId == employeeD.employeeId && Objects.equals(employeeName, employeeD.employeeName) && Objects.equals(employeeSalary, employeeD.employeeSalary) && Objects.equals(departmentId, employeeD.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, employeeSalary, departmentId);
    }

    @Override
    public String toString() {
        return "EmployeeD{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", departmentId=" + departmentId +
                '}';
    }
}

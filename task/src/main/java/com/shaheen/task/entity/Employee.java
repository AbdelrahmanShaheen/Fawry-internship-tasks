package com.shaheen.task.entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private long employeeId;
    @Column(name = "emp_name")
    private String employeeName;
    @Column(name = "emp_salary")
    private Double employeeSalary;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE
                         ,CascadeType.DETACH, CascadeType.REFRESH}
                         ,fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee(){

    }

    public long getEmployeeId() {
        return employeeId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(employeeName, employee.employeeName) && Objects.equals(employeeSalary, employee.employeeSalary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, employeeSalary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", department=" + department +
                '}';
    }
}

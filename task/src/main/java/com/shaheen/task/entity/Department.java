package com.shaheen.task.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "dept_id")
    private Long departmentId;
    @Column(name = "dept_name")
    private String departmentName;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE
                         ,CascadeType.DETACH, CascadeType.REFRESH}
                         ,fetch = FetchType.EAGER
                         ,mappedBy = "department")
    private Set<Employee> employees;

    public Department(){

    }
    public void add(Employee employee){
     if(employees == null){
         employees = new HashSet<>();
     }
     employees.add(employee);
     employee.setDepartment(this);
    }

    public Long getDepartmentId() {
        return departmentId;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId) && Objects.equals(departmentName, that.departmentName) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, employees);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}

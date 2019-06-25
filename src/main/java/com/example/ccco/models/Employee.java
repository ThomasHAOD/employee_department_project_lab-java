package com.example.ccco.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeNumber;
    private String firstName;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    @ManyToMany
    @JoinTable(name = "employees_projects",
    joinColumns = {@JoinColumn(
            name = "employee_id",
            nullable = false,
            updatable = false)},
    inverseJoinColumns = {@JoinColumn(
            name = "project_id",
            nullable = false,
            updatable = false
    )})
    private List<Project> projects;



    public Employee( String firstName, String surname, Department department) {
        this.firstName = firstName;
        this.surname = surname;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Employee() {

    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void addProject(Project project){
        this.projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

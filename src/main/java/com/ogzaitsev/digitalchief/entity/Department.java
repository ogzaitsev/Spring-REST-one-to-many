package com.ogzaitsev.digitalchief.entity;


import jakarta.persistence.*;

import java.io.Serializable;
//import java.util.Collection;
//import java.util.Set;

@Entity
@Table(name = "departments", schema = "d_chief")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "department_name")
    String name;

    @Column
    String description;

    @Column(name = "min_salary")
    int minSalary;

    @Column(name = "max_salary")
    int maxSalary;

//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
//            CascadeType.REFRESH})
//    @JoinColumn(name = "id")
//    Set<Employee> employees;

    public Department(String departmentName, String description, int minSalary, int maxSalary) {
        this.name = departmentName;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Department() {}

//    public Collection<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
//                ", employees=" + employees +
                '}';
    }
}

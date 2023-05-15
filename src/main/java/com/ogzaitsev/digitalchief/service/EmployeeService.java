package com.ogzaitsev.digitalchief.service;

import com.ogzaitsev.digitalchief.entity.Department;
import com.ogzaitsev.digitalchief.entity.Employee;
import com.ogzaitsev.digitalchief.exception.NoSuchEntityException;
import com.ogzaitsev.digitalchief.repository.DepartmentRepository;
import com.ogzaitsev.digitalchief.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElseThrow(NoSuchEntityException::new);
    }

    public Employee saveEmployee(Employee employee) {
        employee.setDepartment(departmentRepository
                .findById(employee.getDepartment().getId())
                .orElseThrow(NoSuchEntityException::new));
        return employeeRepository.save(employee);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Employee updateEmployee(Employee employee) {
        return saveEmployee(employee);
    }

    public Department updateDepartment(Department department) {
        Optional<Department> updated = departmentRepository.findById(department.getId());
        if(updated.isPresent()) {
            return departmentRepository.save(department);
        } else {
            throw new NoSuchEntityException("There is no Department with ID=" + department.getId());
        }
    }

    public String deleteEmployee(int id) {
        if(getEmployeeById(id) == null) {
            throw new NoSuchEntityException("There is no Employee with ID=" + id);
        }
        employeeRepository.deleteById(id);
        return "Employee with ID=" + id + " was deleted";
    }

    public String deleteDepartment(int id) {
        if(getDepartmentById(id) == null) {
            throw new NoSuchEntityException("There is no Department with ID=" + id);
        }
        departmentRepository.deleteById(id);
        return "Department with ID=" + id + " was deleted";
    }

}

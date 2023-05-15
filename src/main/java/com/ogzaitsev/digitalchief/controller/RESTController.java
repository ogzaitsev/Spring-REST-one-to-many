package com.ogzaitsev.digitalchief.controller;

import com.ogzaitsev.digitalchief.entity.Department;
import com.ogzaitsev.digitalchief.entity.Employee;
import com.ogzaitsev.digitalchief.exception.ExceptionResponse;
import com.ogzaitsev.digitalchief.exception.NoSuchEntityException;
import com.ogzaitsev.digitalchief.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("departments")
    public List<Department> getAllDepartments() {
        return employeeService.getAllDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartments(@PathVariable int id) {
        return employeeService.getDepartmentById(id);
    }

    @PostMapping("departments")
    public Department addNewDepartment(@RequestBody Department department) {
        return employeeService.saveDepartment(department);
    }

    @PutMapping("departments")
    public Department updateDepartment(@RequestBody Department department) {
        return employeeService.updateDepartment(department);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return employeeService.deleteDepartment(id);
    }

    @ExceptionHandler(NoSuchEntityException.class)
    private ResponseEntity<ExceptionResponse> handleNoSuchEntityException(
                                                NoSuchEntityException exception) {
        ExceptionResponse response = new ExceptionResponse(
                exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionResponse> handleAnyException(
            Exception exception) {
        ExceptionResponse response = new ExceptionResponse(
                "Unfortunately, server could not digest your request.    " + exception.getMessage(),
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

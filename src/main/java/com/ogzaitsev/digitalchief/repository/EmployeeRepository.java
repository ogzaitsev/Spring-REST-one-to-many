package com.ogzaitsev.digitalchief.repository;

import com.ogzaitsev.digitalchief.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}

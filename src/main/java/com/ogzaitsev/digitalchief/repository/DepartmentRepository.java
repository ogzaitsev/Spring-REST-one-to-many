package com.ogzaitsev.digitalchief.repository;

import com.ogzaitsev.digitalchief.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}

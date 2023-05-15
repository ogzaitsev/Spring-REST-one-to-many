package com.ogzaitsev.digitalchief;

import com.ogzaitsev.digitalchief.entity.Department;
import com.ogzaitsev.digitalchief.entity.Employee;
import com.ogzaitsev.digitalchief.repository.DepartmentRepository;
import com.ogzaitsev.digitalchief.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DigitalChiefTaskApplicationTests {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void addDepartmentTest() {
        Department department = new Department("QA", "Quality Assurance",
                700, 2300);
        Department savedDepartment = departmentRepository.save(department);
        assertThat(savedDepartment.getId()).isGreaterThan(0);
    }

    @Test
    public void addEmployeeTest() {
        Department department = entityManager.find(Department.class, 2);
        Employee employee = new Employee(department, "Ivan", "Fyodorov", 800);
        Employee savedEmployee = employeeRepository.save(employee);
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

}

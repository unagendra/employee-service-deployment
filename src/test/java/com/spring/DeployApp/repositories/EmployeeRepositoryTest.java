package com.spring.DeployApp.repositories;


import com.spring.DeployApp.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestcontainersConfiguration.class)
@DataJpaTest    //Test only Repository Layer independently (includes Embedded DB and Transactional context for every test cases)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  //replace actual DB with Embedded DB
class EmployeeRepositoryTest {

    @Autowired
    private  EmployeeRepository employeeRepository;
    private Employee employee;

    @BeforeEach
    void Setup(){
     employee= Employee.builder()
             .id(1L)
             .name("Anuj")
             .email("anuj@gmail.com")
             .salary(100L)
             .build();
    }

    @Test
    void TestFindByEmail_WhenEmailIsPresent_thenReturnEmployeeList() {

      //1.Arrange the Data (given)
      employeeRepository.save(employee);

      //2.Act by calling the method (when)
      List<Employee> employeeList=employeeRepository.findByEmail(employee.getEmail());

      //3.Assert (then)
      assertThat(employeeList).isNotEmpty();
      assertThat(employeeList).isNotNull();
      assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());

    }

    @Test
    void TestFindByEmail_WhenEmailIsNotPresent_thenReturnEmptyEmployeeList() {
        //Arrange
      String email="abc@gmail.com";
        //Act
      List<Employee> employeeList=employeeRepository.findByEmail(email);
        //Assert
      assertThat(employeeList).isEmpty();
      assertThat(employeeList).isNotNull();

    }
}
package com.bootcamp.spring.data.infrastructure.persistence;

import com.bootcamp.spring.data.domain.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByUuid(UUID uuid);

    @Query( "select e from Employee e" )
    List<Employee> findAll();
}

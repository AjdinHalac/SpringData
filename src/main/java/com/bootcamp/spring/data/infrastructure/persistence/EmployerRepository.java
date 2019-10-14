package com.bootcamp.spring.data.infrastructure.persistence;

import com.bootcamp.spring.data.domain.model.Employer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployerRepository extends CrudRepository<Employer, Long> {

    Optional<Employer> findByUuid(UUID tenantUuid);

    Optional<Employer> findByDisplayId(String displayId);

    @Query( "select t from Employer t" )
    List<Employer> findAll();
}

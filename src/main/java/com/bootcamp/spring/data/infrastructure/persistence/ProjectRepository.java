package com.bootcamp.spring.data.infrastructure.persistence;

import com.bootcamp.spring.data.domain.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findByName(String name);

    @Query( "select o from Project o" )
    List<Project> findAll();
}

package com.bootcamp.spring.data.infrastructure.persistence;

import com.bootcamp.spring.data.domain.model.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends CrudRepository<Office, Long> {

    Optional<Office> findByAddress(String address);

    @Query( "select o from Office o" )
    List<Office> findAll();
}

package com.bootcamp.spring.data.domain.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Hibernate requires no-arg constructor
    protected Employee() {
    }

    public Employee(
            UUID uuid,
            String name,
            String email
    ) {
        this.uuid = uuid;
        this.setName(name);
        this.createdAt = LocalDateTime.now();
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee setEmail(String email){
        if (email != null) {
            this.email = email;
        }
        return this;
    }

    public Employee setName(String name) {
        if (null != name) {
            this.name = name;
        }
        return this;
    }
}

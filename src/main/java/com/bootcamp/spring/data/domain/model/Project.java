package com.bootcamp.spring.data.domain.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    // Hibernate requires no-arg constructor
    protected Project() {
    }

    public Project(String name) {
        this.setName(name);
    }

    private String getName(){
        return this.name;
    }

    private Project setName(String name) {
        this.name = name;
        return this;
    }
}

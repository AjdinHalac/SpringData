package com.bootcamp.spring.data.domain.model;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false, length = 50)
    private String displayId;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEnum type;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "office_id", referencedColumnName = "id", nullable = false)
    private Office office;

    @OneToMany(mappedBy="employer")
    private Set<Employee> employees;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Hibernate requires no-arg constructor
    protected Employer() {
    }

    public Employer(
            UUID uuid,
            String type,
            String name,
            String displayId,
            String email
    ) {
        this.uuid = uuid;
        this.displayId = displayId;
        this
                .setName(name)
                .setType(type)
                .setEmail(email);
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDisplayId() {
        return displayId;
    }

    public String getEmail(){
        return email;
    }

    public TypeEnum getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employer setEmail(String email){
        if (email != null) {
            this.email = email;
        }
        return this;
    }

    private Employer setType(String tntType){
        if(tntType != null && TypeEnum.hasValue(tntType)){
            this.type = TypeEnum.valueOf(tntType);
        } else {
            throw new IllegalArgumentException("Type: '" + tntType + "' does not exist...");
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public Employer setName(String name) {
        if (null != name) {
            this.name = name;
        }
        return this;
    }
}

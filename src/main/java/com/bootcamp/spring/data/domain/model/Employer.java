package com.bootcamp.spring.data.domain.model;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "employer")
public class Employer extends AbstractAggregateRoot {

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

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 50)
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEnum type;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Hibernate requires no-arg constructor
    protected Employer() {
    }

    public Employer(
            UUID uuid,
            String tntType,
            String name,
            String tntDisplayId,
            String email,
            String address,
            String city
    ) {
        this.uuid = uuid;
        this.displayId = tntDisplayId;
        this.setName(name)
            .setType(tntType);
        this.createdAt = LocalDateTime.now();
        this.email = email;
        this.address = address;
        this.city = city;
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

    public String getCity(){
        return city;
    }

    public String getAddress(){
        return address;
    }

    public TypeEnum getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employer setAddress(String address){
        if (address != null) {
            this.address = address;
        }
        return this;
    }

    public Employer setCity(String city){
        if (city != null) {
            this.city = city;
        }
        return this;
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

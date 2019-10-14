package com.bootcamp.spring.data.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String address;

    @Column(nullable = false, length = 50)
    private String city;

    @OneToOne(mappedBy = "office")
    private Employer employer;

    // Hibernate requires no-arg constructor
    protected Office() {
    }

    public Office(
            String name,
            String address,
            String city
    ) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public String getAddress(){
        return address;
    }

    public String getName(){
        return address;
    }

    public Office setAddress(String address){
        if (address != null) {
            this.address = address;
        }
        return this;
    }

    public Office setCity(String city){
        if (city != null) {
            this.city = city;
        }
        return this;
    }

}

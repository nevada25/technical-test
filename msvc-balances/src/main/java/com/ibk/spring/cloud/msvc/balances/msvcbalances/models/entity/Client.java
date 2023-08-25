package com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String maternal_lastName;
    private String paternal_lastName;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaternal_lastName() {
        return maternal_lastName;
    }

    public void setMaternal_lastName(String maternal_lastName) {
        this.maternal_lastName = maternal_lastName;
    }

    public String getPaternal_lastName() {
        return paternal_lastName;
    }

    public void setPaternal_lastName(String paternal_lastName) {
        this.paternal_lastName = paternal_lastName;
    }
}

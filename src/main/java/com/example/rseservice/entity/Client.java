package com.example.rseservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "clients-1")
    private String name;

    @NotNull(message = "clients-2")
    private String document;

    @NotNull(message = "clients-3")
    private LocalDate birthDay;

    public Client() {
    }

    public Client(String name, String document, LocalDate birthDay) {
        this.name = name;
        this.document = document;
        this.birthDay = birthDay;
    }

    public Client(Long id, String name, String document, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public String getDocument() {
        return document;
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

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @JsonIgnore
    public boolean alreadyExist() {
        return getId() != null;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}

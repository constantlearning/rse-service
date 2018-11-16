package com.example.rseservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "client")
    private List<Script> scripts;

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

    public List<Script> getScripts() {
        return scripts;
    }

    public void setScripts(List<Script> scripts) {
        this.scripts = scripts;
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


    public static final class ClientBuilder {
        private Long id;
        private String name;
        private String document;
        private LocalDate birthDay;
        private List<Script> scripts;

        private ClientBuilder() {
        }

        public static ClientBuilder aClient() {
            return new ClientBuilder();
        }

        public ClientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder document(String document) {
            this.document = document;
            return this;
        }

        public ClientBuilder birthDay(LocalDate birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public ClientBuilder scripts(List<Script> scripts) {
            this.scripts = scripts;
            return this;
        }

        public Client build() {
            Client client = new Client();
            client.setId(id);
            client.setName(name);
            client.setDocument(document);
            client.setBirthDay(birthDay);
            client.setScripts(scripts);
            return client;
        }
    }
}

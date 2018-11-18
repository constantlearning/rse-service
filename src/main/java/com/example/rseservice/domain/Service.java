package com.example.rseservice.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    @NotNull(message = "clients-2")
    private String path;

    @NotNull(message = "clients-3")
    private String code;

    @NotNull(message = "clients-3")
    private boolean enabled;

    @OneToMany(mappedBy = "service")
    private List<ServiceHistories> serviceHistories;

    public Service() {
    }

    public Service(Client client, String path, String code, boolean enabled) {
        this.client = client;
        this.path = path;
        this.code = code;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", client=" + client +
                ", path='" + path + '\'' +
                ", code='" + code + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}



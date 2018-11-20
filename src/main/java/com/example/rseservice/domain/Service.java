package com.example.rseservice.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private String path;

    private String title;

    private boolean enabled;

    @OneToMany(mappedBy = "service")
    private List<ServiceHistories> serviceHistories;

    public Service() {
    }

    public Service(Client client, String path, String title) {
        this.client = client;
        this.path = path;
        this.title = title;
        this.enabled = true;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", client=" + client +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}



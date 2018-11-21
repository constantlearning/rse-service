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

    private String language;

    @Column(columnDefinition = "TEXT")
    private String code;

    private String title;

    private boolean enabled;

    @OneToMany(mappedBy = "service")
    private List<ServiceHistories> serviceHistories;

    public Service() {
    }

    public Service(Client client, String code, String title) {
        this.client = client;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public List<ServiceHistories> getServiceHistories() {
        return serviceHistories;
    }

    public void setServiceHistories(List<ServiceHistories> serviceHistories) {
        this.serviceHistories = serviceHistories;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}



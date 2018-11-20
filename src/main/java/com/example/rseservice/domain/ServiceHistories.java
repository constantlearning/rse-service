package com.example.rseservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ServiceHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String executionTime;

    private Timestamp createdat;

    @ManyToOne
    private Service service;

    public ServiceHistories() {
    }

    public ServiceHistories(String executionTime, Timestamp createdat, Service service) {
        this.executionTime = executionTime;
        this.createdat = createdat;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "ServiceHistories{" +
                "id=" + id +
                ", executionTime='" + executionTime + '\'' +
                ", createdat=" + createdat +
                ", service=" + service +
                '}';
    }
}
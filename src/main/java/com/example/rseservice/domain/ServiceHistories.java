package com.example.rseservice.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class ServiceHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer executionTime;

    private Timestamp createdAt;

    @ManyToOne
    private Service service;

    public ServiceHistories() {
    }

    public ServiceHistories(Integer executionTime, Timestamp createdAt, Service service) {
        this.executionTime = executionTime;
        this.createdAt = createdAt;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdat) {
        this.createdAt = createdat;
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
                ", createdat=" + createdAt +
                ", service=" + service +
                '}';
    }
}
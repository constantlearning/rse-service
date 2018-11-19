package com.example.rseservice.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class ServiceHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "clients-2")
    private String executionTime;

    @NotNull(message = "clients-3")
    private LocalDate createdat;

    @ManyToOne
    private ServiceD service;

    public ServiceHistories() {
    }

    public ServiceHistories(String executionTime, LocalDate createdat, ServiceD service) {
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

    public LocalDate getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        this.createdat = createdat;
    }

    public ServiceD getService() {
        return service;
    }

    public void setService(ServiceD service) {
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
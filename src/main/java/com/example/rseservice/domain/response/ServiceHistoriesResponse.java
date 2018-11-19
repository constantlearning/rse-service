package com.example.rseservice.domain.response;

import java.sql.Timestamp;

public class ServiceHistoriesResponse {

    private Long serviceId;

    private String executionTime;

    private Timestamp createdAt;

    public ServiceHistoriesResponse() {
    }

    public ServiceHistoriesResponse(Long serviceId, String executionTime, Timestamp createdAt) {
        this.serviceId = serviceId;
        this.executionTime = executionTime;
        this.createdAt = createdAt;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ServiceHistoriesResponse{" +
                "serviceId=" + serviceId +
                ", executionTime='" + executionTime + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

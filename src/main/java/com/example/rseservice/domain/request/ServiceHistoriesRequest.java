package com.example.rseservice.domain.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

public class ServiceHistoriesRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long serviceId;

    @NotBlank(message = "O campo path deve ser informado")
    private String executionTime;

    private Timestamp createdAt;

    @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
    public ServiceHistoriesRequest(
                @JsonProperty("serviceId") Long serviceId,
                @JsonProperty("executionTime") String executionTime

        ) {
            this.serviceId = serviceId;
            this.executionTime = executionTime;
            this.createdAt = new Timestamp(System.currentTimeMillis());

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        return "ServiceHistoriesRequest{" +
                "serviceId=" + serviceId +
                ", executionTime='" + executionTime + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

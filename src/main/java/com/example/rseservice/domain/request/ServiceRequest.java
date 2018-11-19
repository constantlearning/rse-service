package com.example.rseservice.domain.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ServiceRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "O campo code deve ser informado")
    private String code;

    @NotBlank(message = "O campo path deve ser informado")
    private String path;

//    @NotBlank(message = "O campo clientId deve ser informado")
    private Long clientId;

    private boolean enable;

    @JsonCreator(mode = JsonCreator.Mode.DEFAULT)
    public ServiceRequest(
            @JsonProperty("code") String code,
            @JsonProperty("path") String path,
            @JsonProperty("clientId") Long clientId

    ) {
        this.code = code;
        this.path = path;
        this.clientId = clientId;
        this.enable = true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "code='" + code + '\'' +
                ", enable=" + enable +
                ", path='" + path + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
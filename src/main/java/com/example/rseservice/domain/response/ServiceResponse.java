package com.example.rseservice.domain.response;

public class ServiceResponse {

    private Long id;
    private Long clientId;
    private String code;
    private String path;
    private boolean enable;

    public ServiceResponse() {
    }

    public ServiceResponse(Long id, Long clientId, String code, String path, boolean enable) {
        this.id = id;
        this.clientId = clientId;
        this.code = code;
        this.path = path;
        this.enable = enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", code='" + code + '\'' +
                ", path='" + path + '\'' +
                ", enable=" + enable +
                '}';
    }
}

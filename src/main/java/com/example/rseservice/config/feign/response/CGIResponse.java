package com.example.rseservice.config.feign.response;

public class CGIResponse {

    private Long id;
    private String result;
    private Long timeElapsed;

    public CGIResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CGIResponse that = (CGIResponse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        return timeElapsed != null ? timeElapsed.equals(that.timeElapsed) : that.timeElapsed == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (timeElapsed != null ? timeElapsed.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "CGIResponse{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", timeElapsed=" + timeElapsed +
                '}';
    }

}

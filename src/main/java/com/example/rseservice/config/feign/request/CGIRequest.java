package com.example.rseservice.config.feign.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CGIRequest {

    @NotBlank
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private Long howManyArguments;

    @NotBlank
    private String content;

    @NotNull
    private List<String> args;

    public CGIRequest(@NotBlank Long id, @NotBlank String type, @NotBlank Long howManyArguments, @NotBlank String content, @NotNull List<String> arguments) {
        this.id = id;
        this.type = type;
        this.howManyArguments = howManyArguments;
        this.content = content;
        this.args = arguments;
    }

    public CGIRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getHowManyArguments() {
        return howManyArguments;
    }

    public void setHowManyArguments(Long howManyArguments) {
        this.howManyArguments = howManyArguments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CGIRequest that = (CGIRequest) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (howManyArguments != null ? !howManyArguments.equals(that.howManyArguments) : that.howManyArguments != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return args != null ? args.equals(that.args) : that.args == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (howManyArguments != null ? howManyArguments.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CGIRequest{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", howManyArguments=" + howManyArguments +
                ", content='" + content + '\'' +
                ", args=" + args +
                '}';
    }
}
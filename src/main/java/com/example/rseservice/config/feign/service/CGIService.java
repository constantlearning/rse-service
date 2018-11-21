package com.example.rseservice.config.feign.service;

import com.example.rseservice.config.feign.CGIApi;
import com.example.rseservice.config.feign.request.CGIRequest;
import com.example.rseservice.config.feign.response.CGIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CGIService implements CGI {

    private final CGIApi cgiApi;

    @Autowired
    public CGIService(CGIApi cgiApi) {
        this.cgiApi = cgiApi;
    }

    @Override
    public CGIResponse execute(CGIRequest cgiRequest) {

        return cgiApi.execute(cgiRequest);
    }
}

package com.example.rseservice.config.feign.service;

import com.example.rseservice.config.feign.request.CGIRequest;
import com.example.rseservice.config.feign.response.CGIResponse;

import java.util.List;

public interface CGI {

    CGIResponse execute(CGIRequest cgiRequest);
}

package com.example.rseservice.config.feign;

import com.example.rseservice.config.feign.request.CGIRequest;
import com.example.rseservice.config.feign.response.CGIResponse;
import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CGIApi {

    @RequestLine("POST /cgi")
    @Headers("Content-Type: application/json")
    CGIResponse execute(@RequestBody @Valid CGIRequest request);
}

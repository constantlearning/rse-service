package com.example.rseservice.service.interfaces;

import com.example.rseservice.domain.Service;
import com.example.rseservice.domain.request.ServiceRequest;
import com.example.rseservice.domain.response.ServiceResponse;

import java.util.List;

public interface ServiceServiceI {

    Service create(ServiceRequest serviceRequest);

    ServiceResponse findById(Long id);

    List<ServiceResponse> findAll(Long id);

    Service buildService(ServiceRequest serviceRequest);
}

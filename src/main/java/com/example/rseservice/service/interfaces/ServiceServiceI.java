package com.example.rseservice.service.interfaces;

import com.example.rseservice.domain.ServiceD;
import com.example.rseservice.domain.request.ServiceRequest;
import com.example.rseservice.domain.response.ServiceResponse;

import java.util.List;

public interface ServiceServiceI {

    ServiceD create(ServiceRequest serviceRequest);

    ServiceResponse findById(Long id);

    List<ServiceResponse> findAll(Long id);

    ServiceD buildService(ServiceRequest serviceRequest);
}

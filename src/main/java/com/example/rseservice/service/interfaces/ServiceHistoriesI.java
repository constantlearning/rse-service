package com.example.rseservice.service.interfaces;

import com.example.rseservice.domain.ServiceHistories;
import com.example.rseservice.domain.request.ServiceHistoriesRequest;
import com.example.rseservice.domain.response.ServiceHistoriesResponse;

import java.util.List;

public interface ServiceHistoriesI {

    ServiceHistoriesResponse create(ServiceHistoriesRequest serviceRequest);

    ServiceHistoriesResponse findById(Long id);

    List<ServiceHistoriesResponse> findAllServiceId(Long id);

    ServiceHistories buildService(ServiceHistoriesRequest serviceRequest);
}

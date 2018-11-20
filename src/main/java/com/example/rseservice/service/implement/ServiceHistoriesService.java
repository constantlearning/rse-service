package com.example.rseservice.service.implement;

import com.example.rseservice.domain.Service;
import com.example.rseservice.domain.ServiceHistories;
import com.example.rseservice.domain.request.ServiceHistoriesRequest;
import com.example.rseservice.domain.response.ServiceHistoriesResponse;
import com.example.rseservice.repository.ServiceHistoriesRepository;
import com.example.rseservice.repository.ServiceRepository;
import com.example.rseservice.service.exception.ServiceHistoriesNotFoundException;
import com.example.rseservice.service.interfaces.ServiceHistoriesI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceHistoriesService {

    @Autowired
    private ServiceHistoriesRepository serviceHistoriesRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    /*
    @Override
    public ServiceHistoriesResponse create(ServiceHistoriesRequest serviceRequest) {
        ServiceHistories serviceHistories = buildService(serviceRequest);
        serviceHistories = serviceHistoriesRepository.save(serviceHistories);
        return new ServiceHistoriesResponse(
                serviceHistories.getService().getId(),
                serviceHistories.getExecutionTime(),
                serviceHistories.getCreatedAt()
        );
    }

    @Override
    public ServiceHistoriesResponse findById(Long id) {
        Optional<ServiceHistories> serviceHistoriesOptional = serviceHistoriesRepository.findById(id);
        ServiceHistories serviceHistories = buildService(serviceHistoriesOptional);
        return new ServiceHistoriesResponse(
                serviceHistories.getService().getId(),
                serviceHistories.getExecutionTime(),
                serviceHistories.getCreatedAt()
        );
    }

    @Override
    public List<ServiceHistoriesResponse> findAllServiceId(Long id) {
        Optional<Service> serviceD = serviceRepository.findById(id);
        List<ServiceHistories> serviceHistoriesList = serviceHistoriesRepository.findAllByService(id);
        return buildService(serviceHistoriesList);
    }

    @Override
    public ServiceHistories buildService(ServiceHistoriesRequest serviceRequest) {

        Optional<Service> service = serviceRepository.findById(serviceRequest.getServiceId());
        return new ServiceHistories(
                serviceRequest.getExecutionTime(),
                serviceRequest.getCreatedAt(),
                service.get()
        );
    }

    private ServiceHistories buildService(Optional<ServiceHistories> serviceHistoriesOptional) {

        if(!serviceHistoriesOptional.isPresent()) {
            throw new ServiceHistoriesNotFoundException();
        }
        return serviceHistoriesOptional.get();
    }

    public List<ServiceHistoriesResponse> buildService(List<ServiceHistories> serviceR) {

        List<ServiceHistoriesResponse> serviceDS = new ArrayList<>();

        for(ServiceHistories serviceD : serviceR ){

            serviceDS.add(
                    new ServiceHistoriesResponse(
                            serviceD.getService().getId(),
                            serviceD.getExecutionTime(),
                            serviceD.getCreatedAt()
                    ));
        }
        return serviceDS;
    }

    */
}

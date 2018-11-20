package com.example.rseservice.service.implement;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.Service;
import com.example.rseservice.domain.request.ServiceRequest;
import com.example.rseservice.domain.response.ServiceResponse;
import com.example.rseservice.repository.ClientRepository;
import com.example.rseservice.repository.ServiceRepository;
import com.example.rseservice.service.exception.ClientNotFoundException;
import com.example.rseservice.service.exception.ServiceNotFoundException;
import com.example.rseservice.service.interfaces.ServiceServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements ServiceServiceI {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Service create(ServiceRequest serviceRequest) {
        Service service = buildService(serviceRequest);
        service = serviceRepository.save(service);
        return service;
    }

    @Override
    public ServiceResponse findById(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return buildService(service);
    }

    @Override
    public List<ServiceResponse> findAll(Long id) {
        List<Service> serviceDS = serviceRepository.findAllByClient(id);
        List<ServiceResponse> serviceResponses = buildService(serviceDS);
        return serviceResponses;
    }

    @Override
    public Service buildService(ServiceRequest serviceR) {
        Optional<Client> client = clientRepository.findById(serviceR.getClientId());
        if(!client.isPresent()){
            throw new ClientNotFoundException();
        }
        return new Service(client.get(), serviceR.getPath(),serviceR.getCode());
    }

    public ServiceResponse buildService(Optional<Service> serviceR) {

        if(!serviceR.isPresent()){
            throw new ServiceNotFoundException();
        }
        return new ServiceResponse(
                serviceR.get().getId(),
                serviceR.get().getClient().getId(),
                serviceR.get().getTitle(),
                serviceR.get().getPath(),
                serviceR.get().isEnabled()
        );
    }

    public List<ServiceResponse> buildService(List<Service> serviceR) {

        List<ServiceResponse> serviceDS = new ArrayList<>();

        for(Service serviceD : serviceR ){

            serviceDS.add(
                    new ServiceResponse(
                            serviceD.getId(),
                            serviceD.getClient().getId(),
                            serviceD.getTitle(),
                            serviceD.getPath(),
                            serviceD.isEnabled()
                    ));
        }
        return serviceDS;
    }
}

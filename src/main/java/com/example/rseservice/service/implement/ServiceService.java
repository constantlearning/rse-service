package com.example.rseservice.service.implement;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.ServiceD;
import com.example.rseservice.domain.request.ServiceRequest;
import com.example.rseservice.domain.response.ServiceResponse;
import com.example.rseservice.repository.ClientRepository;
import com.example.rseservice.repository.ServiceRepository;
import com.example.rseservice.service.exception.ClientNotFoundException;
import com.example.rseservice.service.exception.ServiceNotFoundException;
import com.example.rseservice.service.interfaces.ServiceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements ServiceServiceI {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ServiceD create(ServiceRequest serviceRequest) {
        ServiceD service = buildService(serviceRequest);
        service = serviceRepository.save(service);
        return service;
    }

    @Override
    public ServiceResponse findById(Long id) {
        Optional<ServiceD> service = serviceRepository.findById(id);
        return buildService(service);
    }

    @Override
    public List<ServiceResponse> findAll(Long id) {
        List<ServiceD> serviceDS = serviceRepository.findAllByClient(id);
        List<ServiceResponse> serviceResponses = buildService(serviceDS);
        return serviceResponses;
    }

    @Override
    public ServiceD buildService(ServiceRequest serviceR) {
        Optional<Client> client = clientRepository.findById(serviceR.getClientId());
        if(!client.isPresent()){
            throw new ClientNotFoundException();
        }
        return new ServiceD(client.get(), serviceR.getPath(),serviceR.getCode());
    }

    public ServiceResponse buildService(Optional<ServiceD> serviceR) {

        if(!serviceR.isPresent()){
            throw new ServiceNotFoundException();
        }
        return new ServiceResponse(
                serviceR.get().getId(),
                serviceR.get().getClient().getId(),
                serviceR.get().getCode(),
                serviceR.get().getPath(),
                serviceR.get().isEnabled()
        );
    }

    public List<ServiceResponse> buildService(List<ServiceD> serviceR) {

        List<ServiceResponse> serviceDS = new ArrayList<>();

        for(ServiceD serviceD : serviceR ){

            serviceDS.add(
                    new ServiceResponse(
                            serviceD.getId(),
                            serviceD.getClient().getId(),
                            serviceD.getCode(),
                            serviceD.getPath(),
                            serviceD.isEnabled()
                    ));
        }
        return serviceDS;
    }
}

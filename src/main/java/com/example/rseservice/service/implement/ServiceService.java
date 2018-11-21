package com.example.rseservice.service.implement;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.Service;
import com.example.rseservice.domain.request.ServiceRequest;
import com.example.rseservice.domain.response.ServiceResponse;
import com.example.rseservice.repository.ClientRepository;
import com.example.rseservice.repository.ServiceRepository;
import com.example.rseservice.service.exception.ClientNotFoundException;
import com.example.rseservice.service.exception.ServiceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Service findByIdAndClientId(Long id, Long clientId){
        Optional<Service> serviceOptional = this.serviceRepository.findByIdAndClientId(id, clientId);

        if(!serviceOptional.isPresent())
            throw new ServiceNotFoundException();

        Service service = serviceOptional.get();

        return service;
    }

    public Service update(Service service) {
        service = serviceRepository.save(service);
        return service;
    }

    public Service create(Service service) {
        service = serviceRepository.save(service);
        return service;
    }

    
    public Service findById(Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        Service s = service.get();
        return s;
    }

    
    public List<ServiceResponse> findAll(Long id) {
        List<Service> serviceDS = serviceRepository.findAllByClient(id);
        List<ServiceResponse> serviceResponses = buildService(serviceDS);
        return serviceResponses;
    }

    
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
                serviceR.get().getCode(),
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
                            serviceD.getCode(),
                            serviceD.isEnabled()
                    ));
        }
        return serviceDS;
    }
}

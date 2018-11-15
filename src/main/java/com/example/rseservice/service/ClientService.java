package com.example.rseservice.service;

import com.example.rseservice.entity.Client;
import com.example.rseservice.entity.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        verifyIfClientExists(client);
        return this.clientRepository.save(client);
    }

    private void verifyIfClientExists(Client client) {
        final Optional<Client> clientByDocument = this.clientRepository.findByDocument(client.getDocument());

        if (clientByDocument.isPresent() && isNewOrIsUpdatingToADifferentClient(client, clientByDocument.get())) {
            throw new IllegalArgumentException("");
        }
    }

    private boolean isNewOrIsUpdatingToADifferentClient(Client client, Client clientByDocument) {
        return client.alreadyExist() && !clientByDocument.getId().equals(client.getId());
    }

}

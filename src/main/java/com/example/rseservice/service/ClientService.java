package com.example.rseservice.service;

import com.example.rseservice.entity.Client;
import com.example.rseservice.entity.repository.ClientRepository;
import com.example.rseservice.service.exception.ClientAlreadyExistException;
import com.example.rseservice.service.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        verifyIfClientExists(client);
        return this.clientRepository.save(client);
    }

    public Client findClientById(Long id) {
        return this.clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    public List<Client> findAll() {
        List<Client> Clients = this.clientRepository.findAll();
        return Collections.unmodifiableList(Clients);
    }

    public void delete(Long id) {
        final Optional<Client> ClientById = this.clientRepository.findById(id);
        final Client ClientToDelete = ClientById.orElseThrow(ClientNotFoundException::new);
        this.clientRepository.delete(ClientToDelete);
    }

    private void verifyIfClientExists(Client client) {
        final Optional<Client> clientByDocument = this.clientRepository.findByDocument(client.getDocument());

        if (clientByDocument.isPresent() && isNewOrIsUpdatingToADifferentClient(client, clientByDocument.get())) {
            throw new ClientAlreadyExistException("422", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    private boolean isNewOrIsUpdatingToADifferentClient(Client client, Client clientByNameAndType) {
        return client.isNew() || isUpdatingToADifferentClient(client, clientByNameAndType);
    }

    private boolean isUpdatingToADifferentClient(Client client, Client clientByNameAndType) {
        return client.alreadyExist() && !clientByNameAndType.getId().equals(client.getId());
    }

}

package com.example.rseservice.service.interfaces;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.request.ClientRequest;
import com.example.rseservice.domain.response.ClientResponse;

public interface ClientServiceI {

    ClientResponse create(ClientRequest client);

    ClientResponse findById(Long id);

    ClientResponse update(ClientRequest client, Long id);

    void cancelUser(ClientRequest client);

    void clientSaved(Client clientSave);

    void clientExist(Client client);

    void clientNotExist(Client client);

    Client buildClient(ClientRequest clientRequest);
}
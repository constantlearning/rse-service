package com.example.rseservice.service.implement;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.request.ClientRequest;
import com.example.rseservice.domain.response.ClientResponse;
import com.example.rseservice.repository.ClientRepository;
import com.example.rseservice.service.exception.BusinessRuleException;
import com.example.rseservice.service.exception.ClientNotFoundException;
import com.example.rseservice.service.interfaces.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements ClientServiceI {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        clientExist(client);
        client.setEnabled(true);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
        return clientSave;
    }

    @Override
    public ClientResponse findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }
        Client client = clientOptional.get();
        return new ClientResponse(client.getId(), client.getUsername());
    }

    @Override
    public ClientResponse update(ClientRequest clientRequest, Long id) {
        // FIELD'S UPDATE -> NAME
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }
        Client client = clientOptional.get();
        client.setUsername(clientRequest.getUsername());
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
        return new ClientResponse(clientSave.getId(), clientSave.getUsername());
    }

    @Override
    public void cancelUser(ClientRequest clientRequest) {

        Client client = clientRepository.findByCpf(clientRequest.getCpf());
        clientNotExist(client);
        client.setEnabled(false);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
    }

    @Override
    public void clientSaved(Client clientSave) {

        if(clientSave==null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Can Not Register Client");
        }
    }

    @Override
    public void clientExist(Client client) {
        Client clientE = clientRepository.findByCpf(client.getCpf());
        if(clientE!=null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Client Already Has Registration");
        }
    }

    @Override
    public void clientNotExist(Client client)  {
        if(client==null){
            throw new ClientNotFoundException();
        }
    }

    @Override
    public Client buildClient(ClientRequest clientRequest) {
        return new Client(
                clientRequest.getUsername(),
                clientRequest.getCpf(),
                clientRequest.getPassword()
        );
    }
}

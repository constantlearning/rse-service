package com.example.rseservice.service.implement;

import com.example.rseservice.domain.Client;
import com.example.rseservice.domain.request.ClientRequest;
import com.example.rseservice.domain.response.ClientResponse;
import com.example.rseservice.repository.ClientRepository;
import com.example.rseservice.service.exception.BusinessRuleException;
import com.example.rseservice.service.exception.ClientNotFoundException;
import com.example.rseservice.service.interfaces.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private DataSource datasource;

    @Autowired
    private ClientRepository clientRepository;

    private void createUser(String username, String rawPassword){

        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        User userDetails = new User(username, encoder.encode(rawPassword), authorities);
        userDetailsService.createUser(userDetails);
    }

    public Client findByUsername(String username){
        Optional<Client> clientOptional = clientRepository.findByUsername(username);
        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }
        Client client = clientOptional.get();
        return clientOptional.get();

    }

    public Client create(Client client, String rawPassword) {
        clientExist(client);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
        createUser(client.getUsername(), rawPassword);
        return clientSave;
    }

    public ClientResponse findById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }
        Client client = clientOptional.get();
        return new ClientResponse(client.getId(), client.getUsername());
    }

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

    public void cancelUser(ClientRequest clientRequest) {

        Client client = clientRepository.findByCpf(clientRequest.getCpf());
        clientNotExist(client);
        Client clientSave = clientRepository.save(client);
        clientSaved(clientSave);
    }

    public void clientSaved(Client clientSave) {

        if(clientSave==null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Can Not Register Client");
        }
    }

    public void clientExist(Client client) {
        Client clientE = clientRepository.findByCpf(client.getCpf());
        if(clientE!=null) {
            throw new BusinessRuleException("INVALID_REGISTER", "Client Already Has Registration");
        }
    }

    public void clientNotExist(Client client)  {
        if(client==null){
            throw new ClientNotFoundException();
        }
    }

    /*public Client buildClient(ClientRequest clientRequest) {
        return new Client(
                clientRequest.getUsername(),
                clientRequest.getCpf(),
                clientRequest.getPassword()
        );
    }*/
}

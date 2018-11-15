package com.example.rseservice.service;


import com.example.rseservice.entity.Client;
import com.example.rseservice.entity.repository.ClientRepository;
import com.example.rseservice.service.exception.ClientAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClientServiceTest {

    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        clientService = new ClientService(clientRepository);
    }

    @Test
    public void should_create_new_client() {

        when(clientRepository.findByDocument("12345"))
                .thenReturn(Optional.empty());

        Client client = new Client("Lucas", "12345", LocalDate.of(1994, 7, 1));
        Client clientInDatabase = new Client(1L, "Lucas", "999888777666", LocalDate.of(1994, 7, 1));

        when(clientRepository.save(client)).thenReturn(clientInDatabase);

        Client newClient = this.clientService.save(client);

        assertEquals(clientInDatabase, newClient);
    }

    @Test
    public void should_deny_creation_of_client_that_exist() {

        final Client clientInDatabase = new Client("Lucas", "12345", LocalDate.of(1994, 7, 1));

        when(this.clientRepository.findByDocument("12345"))
                .thenReturn(Optional.of(clientInDatabase));

        final Client newClient = new Client("Lucas", "12345", LocalDate.of(1994, 7, 1));

        assertThrows(ClientAlreadyExistException.class, () -> this.clientService.save(newClient));
    }


    @Test
    public void should_get_all_clients_in_database() {

        List<Client> clientsInDatabase = Collections.unmodifiableList(getClientsFromDatabase());

        when(clientRepository.findAll()).thenReturn(clientsInDatabase);

        List<Client> clientsFound = this.clientService.findAll();

        assertNotNull(clientsFound);
        assertFalse(clientsFound.isEmpty());
    }

    private List<Client> getClientsFromDatabase() {
        final Client firstClient = new Client(1L, "Lucas Gontijo", "12345", LocalDate.of(1994, 7, 1));
        final Client secondClient = new Client(2L, "João Da Silva", "54123", LocalDate.of(1980, 3, 15));
        final Client thirdClient = new Client(3L, "Maria Bukowski", "67890", LocalDate.of(1991, 1, 27));
        return Arrays.asList(firstClient, secondClient, thirdClient);
    }
}
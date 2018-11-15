package com.example.rseservice.service;


import com.example.rseservice.entity.Client;
import com.example.rseservice.entity.repository.ClientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

        Client newClient = this.clientService.createClient(client);

        assertEquals(clientInDatabase, newClient);
    }

    @Test
    public void should_deny_creation_of_client_that_exist(){

        final Client clientInDatabase = new Client("Lucas", "12345", LocalDate.of(1994, 7, 1));

        when(this.clientRepository.findByDocument("12345"))
                .thenReturn(Optional.of(clientInDatabase));

        final Client newClient = new Client("Lucas", "12345", LocalDate.of(1994, 7, 1));

        assertThrows(IllegalArgumentException.class, () -> this.clientService.createClient(newClient));
    }
}
package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Client;
import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockitoBean
    private ClientRepository clientRepository;

    @Test
    void testAjouterClient() {
        ClientDTO dto = new ClientDTO("zakaria", "zakaria@gmail.com","Azilal","0607523048");

        Client savedClient = new Client("zakaria", "zakaria@gmail.com","Azilal","0607523048");
        when(clientRepository.save(any())).thenReturn(savedClient);

        ClientDTO result = clientService.save(dto);
        assertEquals("zakaria", result.getNom());
        assertNotNull(result.getId());
    }

    @Test
    void testEmaildejaexistant(){
        String email = "zakaria@gmail.com";
        ClientDTO clientDTO = new ClientDTO("zakaria", email,"Azilal","0607523048");

        Client client = new Client();
        client.setEmail(email);

        when(clientRepository.findByEmail(email)).thenReturn(Optional.of(client));

        assertThrows(RuntimeException.class, () -> {
            clientService.save(clientDTO);
        });

        Mockito.verify(clientRepository, Mockito.never()).save(any());

    }





}

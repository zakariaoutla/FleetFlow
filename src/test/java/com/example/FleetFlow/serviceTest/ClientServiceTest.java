package com.example.FleetFlow.serviceTest;

import com.example.FleetFlow.Models.Client;
import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.repository.ClientRepository;
import com.example.FleetFlow.service.ClientService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;


}

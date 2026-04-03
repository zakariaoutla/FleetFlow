package com.example.FleetFlow.controller;


import com.example.FleetFlow.Models.Client;
import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @PostMapping
    public ClientDTO save(@Valid @RequestBody Client client){
       return clientService.save(client);
    }

    @GetMapping
    public List<ClientDTO> getAllClient(){
        return clientService.getAllClient();
    }

    @DeleteMapping("{id}")
    public void getClientById(@PathVariable long id){
        clientService.delete(id);
    }

    @PutMapping("{id}")
    public ClientDTO update(@Valid @PathVariable long id, @RequestBody ClientDTO client){

        return clientService.update(id, client);

    }

}

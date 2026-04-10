package com.example.FleetFlow.service;


import com.example.FleetFlow.Models.Client;
import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.mapper.ClientMapper;
import com.example.FleetFlow.repository.ClientRepository;
import com.example.FleetFlow.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;
    @Autowired
    private LivraisonRepository livraisonRepository;

    public ClientDTO save(Client client){
        Client c = clientRepository.save(client);
        return clientMapper.toDTO(c);

    }

    public void delete(long id){
        clientRepository.deleteById(id);
    }

    public List<ClientDTO> getAllClient(){
        List<ClientDTO> clients = clientRepository.findAll().stream().map(clientMapper::toDTO).toList();
         return clients;
    }

    public ClientDTO update(long id, ClientDTO client){

        Client c = clientRepository.findById(id).orElse(null);

        c.setNom(client.getNom());
        c.setEmail(client.getEmail());
        c.setTelephone(client.getTelephone());
        c.setVille(client.getVille());

        Client update = clientRepository.save(c);

        return clientMapper.toDTO(update);

    }




}

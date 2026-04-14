package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Client;
import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.mapper.ClientMapper;
import com.example.FleetFlow.repository.ClientRepository;
import com.example.FleetFlow.repository.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final LivraisonRepository livraisonRepository;

    public ClientDTO save(ClientDTO client) {
        Client entity = new Client(client.getNom(), client.getEmail(), client.getVille(), client.getTelephone());
        Client saved = clientRepository.save(entity);
        return clientMapper.toDTO(saved);
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    public List<ClientDTO> getAllClient() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).toList();
    }

    public ClientDTO update(long id, ClientDTO client) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        existing.setNom(client.getNom());
        existing.setEmail(client.getEmail());
        existing.setTelephone(client.getTelephone());
        existing.setVille(client.getVille());

        Client updated = clientRepository.save(existing);
        return clientMapper.toDTO(updated);
    }
}

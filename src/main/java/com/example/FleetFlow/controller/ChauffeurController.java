package com.example.FleetFlow.controller;

import com.example.FleetFlow.Models.Chauffeur;
import com.example.FleetFlow.dto.ChauffeurDTO;
import com.example.FleetFlow.mapper.ChauffeurMapper;
import com.example.FleetFlow.service.ChauffeurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chauffeurs")
@RequiredArgsConstructor
public class ChauffeurController {

    private final ChauffeurService chauffeurService;
    private final ChauffeurMapper chauffeurMapper;

    @PostMapping
    public ResponseEntity<ChauffeurDTO> ajouterChauffeur(@Valid @RequestBody ChauffeurDTO chauffeurDTO) {
        Chauffeur chauffeur = chauffeurMapper.toEntity(chauffeurDTO);
        Chauffeur savedChauffeur = chauffeurService.ajouterChauffeur(chauffeur);
        return new ResponseEntity<>(chauffeurMapper.toDto(savedChauffeur), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChauffeurDTO> modifierChauffeur(@PathVariable long id, @Valid @RequestBody ChauffeurDTO chauffeurDTO) {
        Chauffeur chauffeurDetails = chauffeurMapper.toEntity(chauffeurDTO);
        Chauffeur updatedChauffeur = chauffeurService.modifierChauffeur(id, chauffeurDetails);
        return ResponseEntity.ok(chauffeurMapper.toDto(updatedChauffeur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerChauffeur(@PathVariable long id) {
        chauffeurService.supprimerChauffeur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<ChauffeurDTO>> listerChauffeursDisponibles() {
        List<ChauffeurDTO> disponibles = chauffeurService.listerChauffeursDisponibles().stream()
                .map(chauffeurMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(disponibles);
    }
}

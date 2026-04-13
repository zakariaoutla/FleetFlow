package com.example.FleetFlow.controller;

import com.example.FleetFlow.Models.Livraison;
import com.example.FleetFlow.dto.LivraisonDTO;
import com.example.FleetFlow.enums.StatutLivraison;
import com.example.FleetFlow.mapper.LivraisonMapper;
import com.example.FleetFlow.service.LivraisonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/livraisons")
@RequiredArgsConstructor
public class LivraisonController {

    private final LivraisonService livraisonService;
    private final LivraisonMapper livraisonMapper;

    @PostMapping
    public ResponseEntity<LivraisonDTO> creerLivraison(@Valid @RequestBody LivraisonDTO livraisonDTO) {
        Livraison livraison = livraisonMapper.toEntity(livraisonDTO);
        Livraison savedLivraison = livraisonService.creerLivraison(livraison);
        return new ResponseEntity<>(livraisonMapper.toDto(savedLivraison), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/assigner")
    public ResponseEntity<LivraisonDTO> assignerChauffeurEtVehicule(
            @PathVariable long id,
            @RequestParam long chauffeurId,
            @RequestParam long vehiculeId) {

        Livraison livraison = livraisonService.assignerChauffeurEtVehicule(id, chauffeurId, vehiculeId);
        return ResponseEntity.ok(livraisonMapper.toDto(livraison));
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<LivraisonDTO> modifierStatut(
            @PathVariable long id,
            @RequestParam StatutLivraison statut) {

        Livraison livraison = livraisonService.modifierStatutLivraison(id, statut);
        return ResponseEntity.ok(livraisonMapper.toDto(livraison));
    }

    @GetMapping
    public ResponseEntity<List<LivraisonDTO>> listerLivraisons() {
        List<LivraisonDTO> livraisons = livraisonService.listerToutesLesLivraisons().stream()
                .map(livraisonMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(livraisons);
    }
}

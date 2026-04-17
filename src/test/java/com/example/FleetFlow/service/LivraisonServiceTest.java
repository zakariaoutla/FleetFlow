package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Chauffeur;
import com.example.FleetFlow.Models.Client;
import com.example.FleetFlow.Models.Livraison;
import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.enums.StatutLivraison;
import com.example.FleetFlow.enums.StatutVehicule;
import com.example.FleetFlow.repository.ChauffeurRepository;
import com.example.FleetFlow.repository.ClientRepository;
import com.example.FleetFlow.repository.LivraisonRepository;
import com.example.FleetFlow.repository.VehiculeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.FleetFlow.enums.StatutLivraison.EN_COURS;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class LivraisonServiceTest {
    @Mock
    private LivraisonRepository livraisonRepository;
    @Mock
    private ChauffeurRepository chauffeurRepository;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private VehiculeRepository vehiculeRepository;
    @InjectMocks
    private LivraisonService livraisonService;

    private Client client;
    private Chauffeur chauffeur;
    private Vehicule vehicule;
    private Livraison livraison;

    @BeforeEach
    void setUp(){
        livraison = new Livraison();
        livraison.setId(1);
        livraison.setDateLivraison(LocalDate.now().plusDays(1));
        livraison.setStatut(EN_COURS);
        livraison.setChauffeur(chauffeur);
        livraison.setVehicule(vehicule);
        livraison.setClient(client);

        client = new Client();
        client.setEmail("marouane@gmail.com");
        client.setId(1);
        client.setVille("Beni mellal");
        client.setTelephone("0987654321");

        chauffeur = new Chauffeur();
        chauffeur.setId(1);
        chauffeur.setPermisType("B");
        chauffeur.setTelephone("123456789");
        chauffeur.setDisponible(true);
        chauffeur.setNom("Mohamed");

        vehicule = new Vehicule();
        vehicule.setId(1);
        vehicule.setStatus(StatutVehicule.DISPONIBLE);
        vehicule.setType("Car");
        vehicule.setMatricule("123");
        vehicule.setCapacite(50);
    }
    @Test
    void creaeeLivraisonStatutInitial(){
        when(livraisonRepository.save(any(Livraison.class))).thenReturn(livraison);
        Livraison resultat = livraisonService.creerLivraison(livraison);
        assertNotNull(resultat);
        assertEquals(livraison , resultat);
    }

    @Test
    void assigneChauffeurEtVehicule(){
        when(livraisonRepository.findById(1L)).thenReturn(Optional.of(livraison));
        when(chauffeurRepository.findById(1L)).thenReturn(Optional.of(chauffeur));
        when(vehiculeRepository.findById((long)1)).thenReturn(Optional.of(vehicule));
        when(livraisonRepository.save(any(Livraison.class))).thenReturn(livraison);
        Livraison reslutat = livraisonService.assigneVehiculeEtChauffeur(livraison.getId(), chauffeur.getId() ,(int) vehicule.getId());

        assertNotNull(reslutat);
        assertEquals(livraison.getChauffeur() , chauffeur);
        assertEquals(livraison.getVehicule(), vehicule);
    }

    @Test
    void modfieLeStatus(){
        when(livraisonRepository.findById(1L)).thenReturn(Optional.of(livraison));
        when(livraisonRepository.save(any(Livraison.class))).thenReturn(livraison);

        Livraison resultat = livraisonService.updateLivraisonStatus(1, "LIVREE");
        assertNotNull(resultat);
        assertEquals(resultat.getStatut() , StatutLivraison.valueOf("LIVREE"));
    }

}


package com.example.FleetFlow.service;

import com.example.FleetFlow.Models.Chauffeur;
import com.example.FleetFlow.repository.ChauffeurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChauffeurServiceTest {
    @Mock
    private ChauffeurRepository chauffeurRepository;
    @InjectMocks
    private ChauffeurService chauffeurService;

    private Chauffeur chauffeur1;
    private Chauffeur chauffeur2;
    private Chauffeur chauffeur3;

    @BeforeEach
    void setUp(){
        chauffeur1 = new Chauffeur();
        chauffeur1.setId(1);
        chauffeur1.setNom("Marouane");
        chauffeur1.setDisponible(true);
        chauffeur1.setTelephone("0777209917");
        chauffeur1.setPermisType("B");

        chauffeur2 = new Chauffeur();
        chauffeur2.setId(1);
        chauffeur2.setNom("Bounou");
        chauffeur2.setDisponible(false);
        chauffeur2.setTelephone("0777209916");
        chauffeur2.setPermisType("D");

        chauffeur3 = new Chauffeur();
        chauffeur3.setId(1);
        chauffeur3.setNom("Test");
        chauffeur3.setDisponible(true);
        chauffeur3.setTelephone("0777209915");
        chauffeur3.setPermisType("C");
    }

    @Test
    void listerChquffeursDisponible(){
        List<Chauffeur> chauffeursDisponible = Arrays.asList(chauffeur1,chauffeur3);
        when(chauffeurRepository.findChauffeurByDisponibleTrue()).thenReturn(chauffeursDisponible);

        List<Chauffeur> reslultat = chauffeurService.listerChauffeursDisponibles();

        assertNotNull(reslultat);
        assertEquals(2, reslultat.size());
        assertTrue(reslultat.stream().allMatch(Chauffeur::getDisponible));
        verify(chauffeurRepository, times(1)).findChauffeurByDisponibleTrue();
    }
    @Test
    void listerChauffeursDisponible_non(){
        when(chauffeurRepository.findChauffeurByDisponibleTrue()).thenReturn(Arrays.asList());
        List<Chauffeur> resultat = chauffeurService.listerChauffeursDisponibles();
        assertNotNull(resultat);
        assertTrue(resultat.isEmpty());
    }
    @Test
    void listerTousChauffeurs(){
        List<Chauffeur> toutsChauffeurs = Arrays.asList(chauffeur1,chauffeur2,chauffeur3);
        when(chauffeurRepository.findChauffeurByDisponibleTrue()).thenReturn(toutsChauffeurs);
        List<Chauffeur> resultat = chauffeurService.listerChauffeursDisponibles();
        assertNotNull(resultat);
        assertEquals(3,resultat.size());
    }
}


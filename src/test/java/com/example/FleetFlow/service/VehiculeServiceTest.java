package com.example.FleetFlow.service;


import com.example.FleetFlow.Models.Vehicule;
import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.enums.StatutVehicule;
import com.example.FleetFlow.repository.VehiculeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class VehiculeServiceTest {

    @Autowired
    private VehilculeService vehilculeService;
    @MockitoBean
    VehiculeRepository vehiculeRepository;


    @Test
    void testVehiculeDisponibles(){
        StatutVehicule status = StatutVehicule.valueOf("DISPONIBLE");
        Vehicule vehicule = new Vehicule();
        vehicule.setStatus(status);
        when(vehiculeRepository.findByStatus(status)).thenReturn(List.of(vehicule));

        List<VehiculeDTO> resulte = vehilculeService.findByStatut(status);

        assertNotNull(resulte);
        assertEquals(1, resulte.size());

        assertEquals(status, resulte.get(0).getStatus());
    }

    @Test
    void testlogiquecapacite(){
        Vehicule v1 = new Vehicule();
        v1.setCapacite(10);

        when(vehiculeRepository.findByCapaciteGreaterThan(10)).thenReturn(List.of(v1));

        List<VehiculeDTO> resulte = vehilculeService.findByCapaciteGreaterThan(10);

        assertNotNull(resulte);
        assertEquals(1, resulte.size());
        assertEquals(10, resulte.get(0).getCapacite());
    }
}

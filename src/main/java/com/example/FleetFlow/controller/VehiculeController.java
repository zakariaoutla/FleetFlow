package com.example.FleetFlow.controller;
import com.example.FleetFlow.dto.VehiculeDTO;
import com.example.FleetFlow.service.VehilculeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {

   @Autowired
    VehilculeService vehilculeService;

   @PostMapping
    public VehiculeDTO save(@Valid @RequestBody VehiculeDTO vehicule){
       return vehilculeService.save(vehicule);
   }

   @GetMapping
    public List<VehiculeDTO> getAllVehilcule(){
       return vehilculeService.getAllvicule();
   }

   @DeleteMapping("{id}")
    public void delete(@Valid @PathVariable long id){
       vehilculeService.delete(id);
   }
   @PutMapping("{id}")
    public VehiculeDTO update(@PathVariable long id, @Valid @RequestBody VehiculeDTO vehicule){

       return vehilculeService.update(id, vehicule);
   }

   @GetMapping("/status")
   public List<VehiculeDTO> status(@RequestParam String status){
       return vehilculeService.findByStatut(status);
   }

   @GetMapping("/capacite")
    public List<VehiculeDTO> capacite(@RequestParam int capacite){
       return vehilculeService.findByCapaciteGreaterThan(capacite);
   }
}

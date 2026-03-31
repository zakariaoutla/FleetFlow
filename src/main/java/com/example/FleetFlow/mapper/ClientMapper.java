package com.example.FleetFlow.mapper;

import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.Models.Client;
import org.mapstruct.Mapping;

public interface ClientMapper {

    ClientDTO toDTO(Client client);

}

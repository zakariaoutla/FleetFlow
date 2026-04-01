package com.example.FleetFlow.mapper;

import com.example.FleetFlow.dto.ClientDTO;
import com.example.FleetFlow.Models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

      ClientDTO toDTO(Client client);

}

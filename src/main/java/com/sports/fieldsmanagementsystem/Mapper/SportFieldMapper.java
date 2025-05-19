package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;
import com.sports.fieldsmanagementsystem.Domain.SportField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SportFieldMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "pricePerHour", source = "pricePerHour")
    @Mapping(target = "isIndoor", source = "isIndoor")
    SportFieldDTO toDto(SportField sportField);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "pricePerHour", source = "pricePerHour")
    @Mapping(target = "isIndoor", source = "isIndoor")
    SportField toEntity(SportFieldDTO sportFieldDTO);

    @Mapping(target = "id", source = "id")
    void updateEntityFromDto(SportFieldDTO sportFieldDTO, @MappingTarget SportField sportField);
}
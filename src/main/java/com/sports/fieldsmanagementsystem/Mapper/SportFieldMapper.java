package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;
import com.sports.fieldsmanagementsystem.Domain.SportField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SportFieldMapper {
    @Mapping(target = "location", source = "location")
    SportFieldDTO toDto(SportField sportField);

    @Mapping(target = "location", source = "location")
    SportField toEntity(SportFieldDTO sportFieldDTO);

    void updateEntityFromDto(SportFieldDTO sportFieldDTO, @MappingTarget SportField sportField);
}
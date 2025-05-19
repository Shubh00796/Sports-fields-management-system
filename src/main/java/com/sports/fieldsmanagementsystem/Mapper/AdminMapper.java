package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.AdminDTO;
import com.sports.fieldsmanagementsystem.Domain.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.lang.classfile.Interfaces;

@Mapper(componentModel = "spring")

public interface AdminMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    AdminDTO toDto(Admin admin);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    Admin toEntity(AdminDTO adminDTO);

    @Mapping(target = "id", source = "id")
    void updateEntityFromDto(AdminDTO adminDTO, @MappingTarget Admin admin);
}

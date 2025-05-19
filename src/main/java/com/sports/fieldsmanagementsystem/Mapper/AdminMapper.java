package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.AdminDTO;
import com.sports.fieldsmanagementsystem.Domain.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDTO toDto(Admin admin);

    Admin toEntity(AdminDTO adminDTO);

    void updateEntityFromDto(AdminDTO adminDTO, @MappingTarget Admin admin);
}

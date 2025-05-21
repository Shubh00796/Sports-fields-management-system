package com.sports.fieldsmanagementsystem.Mapper;


import com.sports.fieldsmanagementsystem.Domain.Goal;
import com.sports.fieldsmanagementsystem.DTOs.GoalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GoalMapper {

    GoalDto toDto(Goal goal);

    Goal toEntity(GoalDto goalDto);

    void updateEntityFromDto(GoalDto goalDto, @MappingTarget Goal goal);
}
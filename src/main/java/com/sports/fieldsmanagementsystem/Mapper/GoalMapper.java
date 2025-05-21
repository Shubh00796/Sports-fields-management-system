package com.sports.fieldsmanagementsystem.Mapper;


import com.sports.fieldsmanagementsystem.DTOs.GoalDto;
import com.sports.fieldsmanagementsystem.Domain.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GoalMapper {


    Goal toEntity(GoalDto goalDto);


    GoalDto toDto(Goal goal);

    void updateEntityFromDto(GoalDto goalDto, @MappingTarget Goal goal);
}
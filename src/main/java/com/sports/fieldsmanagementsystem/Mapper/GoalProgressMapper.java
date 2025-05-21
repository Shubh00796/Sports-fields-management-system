package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.Domain.GoalProgress;
import com.sports.fieldsmanagementsystem.DTOs.GoalProgressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GoalProgressMapper {

    GoalProgressDto toDto(GoalProgress goalProgress);

    GoalProgress toEntity(GoalProgressDto goalProgressDto);

    void updateEntityFromDto(GoalProgressDto goalProgressDto, @MappingTarget GoalProgress goalProgress);
}
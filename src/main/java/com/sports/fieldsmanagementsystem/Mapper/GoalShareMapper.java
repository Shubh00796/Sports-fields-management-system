package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.Domain.GoalShare;
import com.sports.fieldsmanagementsystem.DTOs.GoalShareDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GoalShareMapper {

    GoalShareDto toDto(GoalShare goalShare);

    GoalShare toEntity(GoalShareDto goalShareDto);

    void updateEntityFromDto(GoalShareDto goalShareDto, @MappingTarget GoalShare goalShare);
}
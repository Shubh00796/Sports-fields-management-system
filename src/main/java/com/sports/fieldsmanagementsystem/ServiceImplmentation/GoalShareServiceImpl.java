package com.sports.fieldsmanagementsystem.ServiceImplmentation;

import com.sports.fieldsmanagementsystem.DTOs.GoalShareDto;
import com.sports.fieldsmanagementsystem.Domain.Goal;
import com.sports.fieldsmanagementsystem.Domain.GoalShare;
import com.sports.fieldsmanagementsystem.Mapper.GoalShareMapper;
import com.sports.fieldsmanagementsystem.ReposiotryServices.GoalRepositoryService;
import com.sports.fieldsmanagementsystem.ReposiotryServices.GoalShareRepositoryService;
import com.sports.fieldsmanagementsystem.Service.GoalShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalShareServiceImpl implements GoalShareService {
    private final GoalRepositoryService goalRepositoryService;
    private final GoalShareRepositoryService repositoryService;
    private final GoalShareMapper mapper;

    @Override
    public List<GoalShareDto> getAllGoalShares() {
        return repositoryService.getAllGoalShares()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public GoalShareDto getGoalShareById(Long id) {
        GoalShare goalShareById = existingGoalShare(id);

        return mapper.toDto(goalShareById);
    }

    private GoalShare existingGoalShare(Long id) {
        GoalShare goalShareById = repositoryService.getGoalShareById(id);
        return goalShareById;
    }

    @Override
    public GoalShareDto createGoalShare(GoalShareDto goalShareDto) {
        Goal goalById = goalRepositoryService.getGoalById(goalShareDto.getGoalId());
        Objects.requireNonNull(goalById, "Goal with id " + goalShareDto.getGoalId() + " does not exist");
        GoalShare goalShare = mapper.toEntity(goalShareDto);
        return mapper.toDto(repositoryService.createGoalShare(goalShare));
    }

    @Override
    public GoalShareDto updateGoalShare(Long id, GoalShareDto goalShareDto) {
        GoalShare goalShare = existingGoalShare(id);
        mapper.updateEntityFromDto(goalShareDto, goalShare);
        return mapper.toDto(repositoryService.updateGoalShare(goalShare));
    }

    @Override
    public void deleteGoalShare(Long id) {
        repositoryService.deleteGoalShare(id);
    }

    @Override
    public List<GoalShareDto> getGoalSharesByGoalId(Long goalId) {
        return repositoryService.getGoalSharesByGoalId(goalId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public GoalShareDto getGoalShareBySharedCode(UUID sharedCode) {
        return mapper.toDto(repositoryService.getGoalShareBySharedCode(sharedCode));
    }

    @Override
    public List<GoalShareDto> getGoalSharesByIsActive(Boolean isActive) {
        return repositoryService.getGoalSharesByIsActive(isActive)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}

package com.sports.fieldsmanagementsystem.ServiceImplmentation;

import com.sports.fieldsmanagementsystem.DTOs.GoalProgressDto;
import com.sports.fieldsmanagementsystem.Domain.Goal;
import com.sports.fieldsmanagementsystem.Domain.GoalProgress;
import com.sports.fieldsmanagementsystem.Mapper.GoalProgressMapper;
import com.sports.fieldsmanagementsystem.ReposiotryServices.GoalProgressRepositoryService;
import com.sports.fieldsmanagementsystem.ReposiotryServices.GoalRepositoryService;
import com.sports.fieldsmanagementsystem.Service.GoalProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalProgressServiceimpl implements GoalProgressService {
    private final GoalProgressRepositoryService repositoryService;
    private final GoalProgressMapper mapper;
    private final GoalRepositoryService goalRepositoryService;

    @Override
    public List<GoalProgressDto> getAllGoalProgress() {
        return repositoryService.getAllGoalProgress()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public GoalProgressDto getGoalProgressById(Long id) {
        GoalProgress repositoryServiceGoalProgressById = existingGoalProgress(id);
        return mapper.toDto(repositoryServiceGoalProgressById);
    }

    private GoalProgress existingGoalProgress(Long id) {
        GoalProgress repositoryServiceGoalProgressById = repositoryService.getGoalProgressById(id);
        return repositoryServiceGoalProgressById;
    }

    @Override
    public GoalProgressDto createGoalProgress(GoalProgressDto goalProgressDto) {
        Objects.requireNonNull(goalProgressDto.getGoalId());

        Goal serviceGoalById = goalRepositoryService.getGoalById(goalProgressDto.getGoalId());
        Objects.requireNonNull(serviceGoalById, "Goal with id " + goalProgressDto.getGoalId() + " does not exist");

        GoalProgress entity = mapper.toEntity(goalProgressDto);
        GoalProgress goalProgress = repositoryService.createGoalProgress(entity);


        return mapper.toDto(goalProgress);
    }

    @Override
    public GoalProgressDto updateGoalProgress(Long id, GoalProgressDto goalProgressDto) {
        Objects.requireNonNull(goalProgressDto.getGoalId());
        Objects.requireNonNull(goalProgressDto.getId());


        GoalProgress goalProgress = existingGoalProgress(id);
        mapper.updateEntityFromDto(goalProgressDto, goalProgress);
        GoalProgress updateGoalProgress = repositoryService.updateGoalProgress(goalProgress);
        return mapper.toDto(updateGoalProgress);

    }

    @Override
    public void deleteGoalProgress(Long id) {
        repositoryService.deleteGoalProgress(id);
    }

    @Override
    public List<GoalProgressDto> getGoalProgressByGoalId(Long goalId) {
        return repositoryService.getGoalProgressByGoalId(goalId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public List<GoalProgressDto> getGoalProgressByLogDate(LocalDate logDate) {
        return repositoryService.getGoalProgressByLogDate(logDate)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}

package com.sports.fieldsmanagementsystem.ServiceImplmentation;

import com.sports.fieldsmanagementsystem.DTOs.GoalDto;
import com.sports.fieldsmanagementsystem.Domain.Goal;
import com.sports.fieldsmanagementsystem.Domain.GoalFrequency;
import com.sports.fieldsmanagementsystem.Mapper.GoalMapper;
import com.sports.fieldsmanagementsystem.ReposiotryServices.GoalRepositoryService;
import com.sports.fieldsmanagementsystem.Service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {
    private final GoalRepositoryService repositoryService;
    private final GoalMapper mapper;

    @Override
    public List<GoalDto> getAllGoals() {
        return repositoryService.getAllGoals()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public GoalDto getGoalById(Long id) {
        Goal serviceGoalById = repositoryService.getGoalById(id);
        return mapper.toDto(serviceGoalById);
    }

    @Override
    public GoalDto createGoal(GoalDto goalDto) {
        Objects.requireNonNull(goalDto.getTitle());
        Objects.requireNonNull(goalDto.getUserId());
        Goal entity = mapper.toEntity(goalDto);
        Goal serviceGoal = repositoryService.createGoal(entity);
        return mapper.toDto(serviceGoal);
    }

    @Override
    public GoalDto updateGoal(GoalDto goalDto) {
        Goal existingGOal = repositoryService.getGoalById(goalDto.getId());
        mapper.updateEntityFromDto(goalDto, existingGOal);
        Goal updatedGoal = repositoryService.updateGoal(existingGOal);

        return mapper.toDto(updatedGoal);
    }

    @Override
    public void deleteGoal(Long id) {
        repositoryService.deleteGoal(id);
    }

    @Override
    public List<GoalDto> getGoalsByUserId(Long userId) {
        return repositoryService.getGoalsByUserId(userId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public List<GoalDto> getGoalsByTitle(String title) {
        return repositoryService.getGoalsByTitle(title)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}

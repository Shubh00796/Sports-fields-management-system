package com.sports.fieldsmanagementsystem.Service;

import com.sports.fieldsmanagementsystem.DTOs.GoalDto;

import java.util.List;

public interface GoalService {

    List<GoalDto> getAllGoals();

    GoalDto getGoalById(Long id);

    GoalDto createGoal(GoalDto goalDto);

    GoalDto updateGoal(GoalDto goalDto);

    void deleteGoal(Long id);

    List<GoalDto> getGoalsByUserId(Long userId);

    List<GoalDto> getGoalsByTitle(String title);
}
package com.sports.fieldsmanagementsystem.Service;

import com.sports.fieldsmanagementsystem.DTOs.GoalProgressDto;

import java.util.List;

public interface GoalProgressService {

    List<GoalProgressDto> getAllGoalProgress();

    GoalProgressDto getGoalProgressById(Long id);

    GoalProgressDto createGoalProgress(GoalProgressDto goalProgressDto);

    GoalProgressDto updateGoalProgress(Long id, GoalProgressDto goalProgressDto);

    void deleteGoalProgress(Long id);

    List<GoalProgressDto> getGoalProgressByGoalId(Long goalId);

    List<GoalProgressDto> getGoalProgressByLogDate(java.time.LocalDate logDate);
}
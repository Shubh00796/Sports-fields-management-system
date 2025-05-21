package com.sports.fieldsmanagementsystem.Service;

import com.sports.fieldsmanagementsystem.DTOs.GoalShareDto;

import java.util.List;
import java.util.UUID;

public interface GoalShareService {

    List<GoalShareDto> getAllGoalShares();

    GoalShareDto getGoalShareById(Long id);

    GoalShareDto createGoalShare(GoalShareDto goalShareDto);

    GoalShareDto updateGoalShare(Long id, GoalShareDto goalShareDto);

    void deleteGoalShare(Long id);

    List<GoalShareDto> getGoalSharesByGoalId(Long goalId);

    GoalShareDto getGoalShareBySharedCode(UUID sharedCode);

    List<GoalShareDto> getGoalSharesByIsActive(Boolean isActive);
}

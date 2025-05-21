package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.DTOs.GoalProgressDto;
import com.sports.fieldsmanagementsystem.Domain.Goal;
import com.sports.fieldsmanagementsystem.Domain.GoalProgress;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Reposiotry.GoalProgressRepository;
import com.sports.fieldsmanagementsystem.Service.GoalProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component
public class GoalProgressRepositoryService {
    private final GoalProgressRepository repository;

    public List<GoalProgress> getAllGoalProgress() {
        return repository.findAll();
    }

    public GoalProgress getGoalProgressById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id with given goalprogress not found" + id));
    }

    public GoalProgress createGoalProgress(GoalProgress goalProgress) {
        checkIfGoalIsNullOrNot(goalProgress);
        return repository.save(goalProgress);
    }

    private static void checkIfGoalIsNullOrNot(GoalProgress goal) {
        if (goal == null) {
            throw new IllegalArgumentException("Goal cannot be null");
        }
    }

    public GoalProgress updateGoalProgress(GoalProgress goalProgress) {
        checkIfGoalIsNullOrNot(goalProgress);

        return repository.save(goalProgress);
    }

    public void deleteGoalProgress(Long id) {
        repository.deleteById(id);
    }

    public List<GoalProgress> getGoalProgressByGoalId(Long goalId) {
        return repository.findByGoalId(goalId);
    }

    public List<GoalProgress> getGoalProgressByLogDate(LocalDate logDate) {
        return repository.findByLogDate(logDate);
    }
}

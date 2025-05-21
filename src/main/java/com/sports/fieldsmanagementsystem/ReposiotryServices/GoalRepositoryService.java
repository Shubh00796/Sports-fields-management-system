package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.DTOs.GoalDto;
import com.sports.fieldsmanagementsystem.Domain.Goal;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Reposiotry.GoalRepository;
import com.sports.fieldsmanagementsystem.Service.GoalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GoalRepositoryService {
    private final GoalRepository repository;

    public List<Goal> getAllGoals() {
        return repository.findAll();
    }

    public Goal getGoalById(Long id) {
        return repository.findById(id
        ).orElseThrow(() -> new ResourceNotFoundException("ID with given goal not found" + id));
    }

    public Goal createGoal(Goal goal) {
        checkIfGoalIsNullOrNot(goal);
        return repository.save(goal);
    }

    private static void checkIfGoalIsNullOrNot(Goal goal) {
        if (goal == null) {
            throw new IllegalArgumentException("Goal cannot be null");
        }
    }

    public Goal updateGoal(Goal goal) {
        checkIfGoalIsNullOrNot(goal);

        return repository.save(goal);
    }

    public void deleteGoal(Long id) {
        repository.deleteById(id);
    }

    public List<Goal> getGoalsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Goal> getGoalsByTitle(String title) {
        return repository.findByTitle(title);
    }
}

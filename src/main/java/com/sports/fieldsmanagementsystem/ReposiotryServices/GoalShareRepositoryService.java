package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.Domain.GoalShare;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Reposiotry.GoalShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GoalShareRepositoryService {
    private final GoalShareRepository repository;

    public List<GoalShare> getAllGoalShares() {
        return repository.findAll();
    }

    public GoalShare getGoalShareById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given goal not found" + id));
    }

    private static void checkIfGoalIsNullOrNot(GoalShare goal) {
        if (goal == null) {
            throw new IllegalArgumentException("Goal cannot be null");
        }
    }

    public GoalShare createGoalShare(GoalShare goalShare) {
        checkIfGoalIsNullOrNot(goalShare);
        return repository.save(goalShare);
    }

    public GoalShare updateGoalShare(GoalShare goalShare) {
        checkIfGoalIsNullOrNot(goalShare);

        return repository.save(goalShare);
    }

    public void deleteGoalShare(Long id) {
        repository.deleteById(id);
    }

    public List<GoalShare> getGoalSharesByGoalId(Long goalId) {
        return repository.findByGoalId(goalId);
    }

    public GoalShare getGoalShareBySharedCode(UUID gUuid) {
        return repository.findBySharedCode(gUuid);
    }

    public List<GoalShare> getGoalSharesByIsActive(Boolean isActive) {
        return repository.findByIsActive(isActive);
    }
}

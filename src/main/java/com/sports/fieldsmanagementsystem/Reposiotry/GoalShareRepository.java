package com.sports.fieldsmanagementsystem.Reposiotry;

import com.sports.fieldsmanagementsystem.Domain.GoalShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GoalShareRepository extends JpaRepository<GoalShare, Long> {

    List<GoalShare> findByGoalId(Long goalId);

    GoalShare findBySharedCode(UUID sharedCode);

    List<GoalShare> findByIsActive(Boolean isActive);

    GoalShare findByGoalIdAndSharedCode(Long goalId, UUID sharedCode);

    List<GoalShare> findByGoalIdAndIsActive(Long goalId, Boolean isActive);
}
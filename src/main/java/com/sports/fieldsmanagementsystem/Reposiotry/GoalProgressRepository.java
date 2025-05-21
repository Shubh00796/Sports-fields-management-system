package com.sports.fieldsmanagementsystem.Reposiotry;


import com.sports.fieldsmanagementsystem.Domain.GoalProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GoalProgressRepository extends JpaRepository<GoalProgress, Long> {

    List<GoalProgress> findByGoalId(Long goalId);

    GoalProgress findByLogDate(LocalDate logDate);

    List<GoalProgress> findByProgressValue(Integer progressValue);
}

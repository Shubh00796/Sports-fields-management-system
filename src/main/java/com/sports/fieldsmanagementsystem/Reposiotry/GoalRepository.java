package com.sports.fieldsmanagementsystem.Reposiotry;

import com.sports.fieldsmanagementsystem.Domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findByUserId(Long userId);

    List<Goal> findByTitle(String title);


}
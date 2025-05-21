package com.sports.fieldsmanagementsystem.Controllers;

import com.sports.fieldsmanagementsystem.DTOs.GoalProgressDto;
import com.sports.fieldsmanagementsystem.Service.GoalProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/goal-progress")
@RequiredArgsConstructor
public class GoalProgressController {

    private final GoalProgressService goalProgressService;

    @GetMapping
    public ResponseEntity<List<GoalProgressDto>> getAllGoalProgress() {
        List<GoalProgressDto> goalProgressDtos = goalProgressService.getAllGoalProgress();
        return ResponseEntity.ok(goalProgressDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalProgressDto> getGoalProgressById(@PathVariable Long id) {
        GoalProgressDto goalProgressDto = goalProgressService.getGoalProgressById(id);
        return ResponseEntity.ok(goalProgressDto);
    }

    @PostMapping
    public ResponseEntity<GoalProgressDto> createGoalProgress(@RequestBody GoalProgressDto goalProgressDto) {
        GoalProgressDto createdGoalProgressDto = goalProgressService.createGoalProgress(goalProgressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoalProgressDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalProgressDto> updateGoalProgress(@PathVariable Long id, @RequestBody GoalProgressDto goalProgressDto) {
        goalProgressDto.setId(id);
        GoalProgressDto updatedGoalProgressDto = goalProgressService.updateGoalProgress(id, goalProgressDto);
        return ResponseEntity.ok(updatedGoalProgressDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoalProgress(@PathVariable Long id) {
        goalProgressService.deleteGoalProgress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/goal/{goalId}")
    public ResponseEntity<List<GoalProgressDto>> getGoalProgressByGoalId(@PathVariable Long goalId) {
        List<GoalProgressDto> goalProgressDtos = goalProgressService.getGoalProgressByGoalId(goalId);
        return ResponseEntity.ok(goalProgressDtos);
    }

    @GetMapping("/log-date")
    public ResponseEntity<List<GoalProgressDto>> getGoalProgressByLogDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate logDate) {
        List<GoalProgressDto> goalProgressDtos = goalProgressService.getGoalProgressByLogDate(logDate);
        return ResponseEntity.ok(goalProgressDtos);
    }
}
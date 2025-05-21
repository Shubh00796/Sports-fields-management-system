package com.sports.fieldsmanagementsystem.Controllers;

import com.sports.fieldsmanagementsystem.DTOs.GoalShareDto;
import com.sports.fieldsmanagementsystem.Service.GoalShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/goal-shares")
@RequiredArgsConstructor
public class GoalShareController {

    private final GoalShareService goalShareService;

    @GetMapping
    public ResponseEntity<List<GoalShareDto>> getAllGoalShares() {
        List<GoalShareDto> goalShareDtos = goalShareService.getAllGoalShares();
        return ResponseEntity.ok(goalShareDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalShareDto> getGoalShareById(@PathVariable Long id) {
        GoalShareDto goalShareDto = goalShareService.getGoalShareById(id);
        return ResponseEntity.ok(goalShareDto);
    }

    @PostMapping
    public ResponseEntity<GoalShareDto> createGoalShare(@RequestBody GoalShareDto goalShareDto) {
        GoalShareDto createdGoalShareDto = goalShareService.createGoalShare(goalShareDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoalShareDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalShareDto> updateGoalShare(@PathVariable Long id, @RequestBody GoalShareDto goalShareDto) {
        goalShareDto.setId(id);
        GoalShareDto updatedGoalShareDto = goalShareService.updateGoalShare(id, goalShareDto);
        return ResponseEntity.ok(updatedGoalShareDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoalShare(@PathVariable Long id) {
        goalShareService.deleteGoalShare(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/goal/{goalId}")
    public ResponseEntity<List<GoalShareDto>> getGoalSharesByGoalId(@PathVariable Long goalId) {
        List<GoalShareDto> goalShareDtos = goalShareService.getGoalSharesByGoalId(goalId);
        return ResponseEntity.ok(goalShareDtos);
    }

    @GetMapping("/shared-code/{sharedCode}")
    public ResponseEntity<GoalShareDto> getGoalShareBySharedCode(@PathVariable UUID sharedCode) {
        GoalShareDto goalShareDto = goalShareService.getGoalShareBySharedCode(sharedCode);
        return ResponseEntity.ok(goalShareDto);
    }

    @GetMapping("/is-active/{isActive}")
    public ResponseEntity<List<GoalShareDto>> getGoalSharesByIsActive(@PathVariable Boolean isActive) {
        List<GoalShareDto> goalShareDtos = goalShareService.getGoalSharesByIsActive(isActive);
        return ResponseEntity.ok(goalShareDtos);
    }
}
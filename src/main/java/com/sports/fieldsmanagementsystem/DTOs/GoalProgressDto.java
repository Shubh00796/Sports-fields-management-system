package com.sports.fieldsmanagementsystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalProgressDto {
    private Long id;
    private Long goalId;
    private LocalDate logDate;
    private String progressNote;
    private Integer progressValue;
    private LocalDateTime createdAt;
}
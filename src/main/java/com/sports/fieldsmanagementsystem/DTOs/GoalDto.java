package com.sports.fieldsmanagementsystem.DTOs;

import com.sports.fieldsmanagementsystem.Domain.GoalFrequency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private LocalDate deadline;
    private GoalFrequency frequency;
    private LocalDateTime createdAt;
}
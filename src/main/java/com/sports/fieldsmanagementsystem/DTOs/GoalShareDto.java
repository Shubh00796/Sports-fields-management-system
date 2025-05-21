package com.sports.fieldsmanagementsystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalShareDto {
    private Long id;
    private Long goalId;
    private UUID sharedCode;
    private Boolean isActive;
    private LocalDateTime createdAt;
}
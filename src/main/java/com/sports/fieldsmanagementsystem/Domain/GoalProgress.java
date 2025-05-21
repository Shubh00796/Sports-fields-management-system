package com.sports.fieldsmanagementsystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goal_progress")
public class GoalProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "goal_id")
    private Long goalId;

    @Column(name = "log_date")
    private LocalDate logDate;

    @Column(name = "progress_note")
    private String progressNote;

    @Column(name = "progress_value")
    private Integer progressValue;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    // Getters and Setters (Lombok handles them)
}
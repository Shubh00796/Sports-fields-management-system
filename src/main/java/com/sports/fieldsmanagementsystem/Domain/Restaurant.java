package com.sports.fieldsmanagementsystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "restaurantsForEasy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(unique = true)
    private String name;

    private String address;
    private String cuisine;
    private String hours;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedAt;

    @Version
    @Column(columnDefinition = "INTEGER DEFAULT 0")
    private Integer version;
}
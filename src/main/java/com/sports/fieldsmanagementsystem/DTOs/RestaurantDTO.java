package com.sports.fieldsmanagementsystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDTO {
    private String id;
    private String name;
    private String address;
    private String cuisine;
    private String hours;
    private Boolean deleted;
    private LocalDateTime deletedAt;
}

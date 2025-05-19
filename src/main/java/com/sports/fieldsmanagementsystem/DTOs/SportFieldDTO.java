package com.sports.fieldsmanagementsystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportFieldDTO {
    private Long id;
    private String name;
    private String type;
    private String location;
    private Double pricePerHour;
    private Boolean isIndoor;
}
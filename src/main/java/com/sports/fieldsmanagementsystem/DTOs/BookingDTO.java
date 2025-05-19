package com.sports.fieldsmanagementsystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;

    private String clientName;

    private String clientPhone;

    private String clientEmail;

    private Long sportFieldId;

    private LocalDate bookingDate;

    private Integer bookingHour;

    private double lat;
    private double lon;
}
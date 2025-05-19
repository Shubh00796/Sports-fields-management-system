package com.sports.fieldsmanagementsystem.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Client name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Client name must only contain letters and spaces")
    private String clientName;

    @NotBlank(message = "Client phone is required")
    @Pattern(regexp = "^\\d{10}$", message = "Client phone must be a 10-digit number")
    private String clientPhone;

    @NotBlank(message = "Client email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid client email")
    private String clientEmail;

    @NotNull(message = "Sport field ID is required")
    private Long sportFieldId;


    private LocalDate bookingDate;

    @NotNull(message = "Booking hour is required")
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3])$", message = "Booking hour must be between 00 and 23")
    private Integer bookingHour;
}
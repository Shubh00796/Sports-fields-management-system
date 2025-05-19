package com.sports.fieldsmanagementsystem.Service;

import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SportFieldService {

    List<SportFieldDTO> getAllSportFields();

    SportFieldDTO getSportFieldById(Long id);

    SportFieldDTO createSportField(SportFieldDTO sportFieldDTO);

    SportFieldDTO updateSportField(SportFieldDTO sportFieldDTO);

    void deleteSportField(Long id);

    // Additional methods
    List<SportFieldDTO> getSportFieldsByType(String type);

    List<SportFieldDTO> getSportFieldsByLocation(String location);

    List<SportFieldDTO> getAvailableSportFields(LocalDate bookingDate);


}
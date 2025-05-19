package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;
import com.sports.fieldsmanagementsystem.Service.SportFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SportFieldReposiotryService implements SportFieldService {
    @Override
    public List<SportFieldDTO> getAllSportFields() {
        return List.of();
    }

    @Override
    public SportFieldDTO getSportFieldById(Long id) {
        return null;
    }

    @Override
    public SportFieldDTO createSportField(SportFieldDTO sportFieldDTO) {
        return null;
    }

    @Override
    public SportFieldDTO updateSportField(SportFieldDTO sportFieldDTO) {
        return null;
    }

    @Override
    public void deleteSportField(Long id) {

    }

    @Override
    public List<SportFieldDTO> getSportFieldsByType(String type) {
        return List.of();
    }

    @Override
    public List<SportFieldDTO> getSportFieldsByLocation(String location) {
        return List.of();
    }

    @Override
    public List<SportFieldDTO> getAvailableSportFields(Date date) {
        return List.of();
    }

    @Override
    public SportFieldDTO bookSportField(Long sportFieldId, Date date, Integer hour) {
        return null;
    }
}

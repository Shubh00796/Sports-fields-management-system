package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.Domain.SportField;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Reposiotry.SportFieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SportFieldReposiotryService {
    private final SportFieldRepository sportFieldRepository;

    public List<SportField> getAllSportFields() {
        return sportFieldRepository.findAll();
    }

    public SportField getSportFieldById(Long id) {
        return sportFieldRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id with given filed not found" + id));
    }

    public SportField createSportField(SportField sportField) {
        return sportFieldRepository.save(sportField);
    }

    public SportField updateSportField(SportField sportField) {
        return sportFieldRepository.save(sportField);
    }

    public void deleteSportField(Long id) {
        sportFieldRepository.deleteById(id);

    }

    public List<SportField> getSportFieldsByType(String type) {
        return sportFieldRepository.findByType(type);
    }

    public List<SportField> getSportFieldsByLocation(String location) {
        return sportFieldRepository.findByLocation(location);
    }

    public List<SportField> getAvailableSportFields(LocalDate booLocalDate) {
        return sportFieldRepository.getAvailableSportFields(booLocalDate);
    }


}

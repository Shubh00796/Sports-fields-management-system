package com.sports.fieldsmanagementsystem.ServiceImplmentation;

import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;
import com.sports.fieldsmanagementsystem.Domain.SportField;
import com.sports.fieldsmanagementsystem.Mapper.SportFieldMapper;
import com.sports.fieldsmanagementsystem.ReposiotryServices.SportFieldReposiotryService;
import com.sports.fieldsmanagementsystem.Service.SportFieldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SportFieldServiceImpl implements SportFieldService {
    private final SportFieldReposiotryService sportFieldReposiotryService;
    private final SportFieldMapper mapper;
//    private final Validator validator;


    @Override
    public List<SportFieldDTO> getAllSportFields() {
        return sportFieldReposiotryService.getAllSportFields()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public SportFieldDTO getSportFieldById(Long id) {
        SportField sportFieldById = sportFieldReposiotryService.getSportFieldById(id);
        return mapper.toDto(sportFieldById);
    }

    @Override
    public SportFieldDTO createSportField(SportFieldDTO sportFieldDTO) {
        SportField sportField = mapper.toEntity(sportFieldDTO);
//        validateSportFields(sportField);
        SportField serviceSportField = sportFieldReposiotryService.createSportField(sportField);
        return mapper.toDto(serviceSportField);
    }

    @Override
    public SportFieldDTO updateSportField(SportFieldDTO sportFieldDTO) {
        SportField existingSportsFileds = sportFieldReposiotryService.getSportFieldById(sportFieldDTO.getId());
//        validateSportFields(existingSportsFileds);
        mapper.updateEntityFromDto(sportFieldDTO, existingSportsFileds);
        SportField updatedSportField = sportFieldReposiotryService.updateSportField(existingSportsFileds);

        return mapper.toDto(updatedSportField);
    }

    @Override
    public void deleteSportField(Long id) {
        sportFieldReposiotryService.deleteSportField(id);

    }

    @Override
    public List<SportFieldDTO> getSportFieldsByType(String type) {
        return sportFieldReposiotryService.getSportFieldsByType(type)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public List<SportFieldDTO> getSportFieldsByLocation(String location) {
        return sportFieldReposiotryService.getSportFieldsByLocation(location)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<SportFieldDTO> getAvailableSportFields(LocalDate bookingDate) {
        List<SportField> availableFields = sportFieldReposiotryService.getAvailableSportFields(bookingDate);
        return availableFields.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

//    private void validateSportFields(SportField sportField) {
//        Set<ConstraintViolation<SportField>> violations = validator.validate(sportField);
//        if (!violations.isEmpty()) {
//            throw new ConstraintViolationException(violations);
//        }
//    }

}

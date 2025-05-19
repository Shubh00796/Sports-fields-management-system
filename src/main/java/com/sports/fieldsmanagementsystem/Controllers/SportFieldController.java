package com.sports.fieldsmanagementsystem.Controllers;

import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;
import com.sports.fieldsmanagementsystem.Service.SportFieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sport-fields")
@RequiredArgsConstructor
public class SportFieldController {

    private final SportFieldService sportFieldService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SportFieldDTO>> getAllSportFields() {
        List<SportFieldDTO> sportFields = sportFieldService.getAllSportFields();
        return ResponseEntity.ok(sportFields);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SportFieldDTO> getSportFieldById(@PathVariable Long id) {
        SportFieldDTO sportField = sportFieldService.getSportFieldById(id);
        return ResponseEntity.ok(sportField);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SportFieldDTO> createSportField(@RequestBody SportFieldDTO sportFieldDTO) {
        SportFieldDTO createdSportField = sportFieldService.createSportField(sportFieldDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSportField);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SportFieldDTO> updateSportField(@PathVariable Long id, @RequestBody SportFieldDTO sportFieldDTO) {
        sportFieldDTO.setId(id); // Set the ID to match the path variable
        SportFieldDTO updatedSportField = sportFieldService.updateSportField(sportFieldDTO);
        return ResponseEntity.ok(updatedSportField);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteSportField(@PathVariable Long id) {
        sportFieldService.deleteSportField(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SportFieldDTO>> getSportFieldsByType(@PathVariable String type) {
        List<SportFieldDTO> sportFields = sportFieldService.getSportFieldsByType(type);
        return ResponseEntity.ok(sportFields);
    }

    @GetMapping("/location/{location}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SportFieldDTO>> getSportFieldsByLocation(@PathVariable String location) {
        List<SportFieldDTO> sportFields = sportFieldService.getSportFieldsByLocation(location);
        return ResponseEntity.ok(sportFields);
    }



    @GetMapping("/available/{date}")
    public ResponseEntity<List<SportFieldDTO>> getAvailableSportFields(@PathVariable LocalDate date) {
        List<SportFieldDTO> availableFields = sportFieldService.getAvailableSportFields(date);
        return ResponseEntity.ok(availableFields);
    }
}
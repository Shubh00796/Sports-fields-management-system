package com.sports.fieldsmanagementsystem.ServiceImplmentation;

import com.sports.fieldsmanagementsystem.DTOs.RestaurantDTO;
import com.sports.fieldsmanagementsystem.Domain.Restaurant;
import com.sports.fieldsmanagementsystem.Exceptions.RestaurantNotFoundException;
import com.sports.fieldsmanagementsystem.Mapper.RestaurantMapper;
import com.sports.fieldsmanagementsystem.ReposiotryServices.RestaurantRepositoryService;
import com.sports.fieldsmanagementsystem.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepositoryService repositoryService;
    private final RestaurantMapper mapper;

    @Override
    @Transactional
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        validateRestaurantDTO(restaurantDTO);
        genrateRandonUUIDIfIdIsNull(restaurantDTO);
        Restaurant restaurant = mapper.toEntity(restaurantDTO);
        Restaurant repositoryServiceRestaurant = repositoryService.createRestaurant(restaurant);
        log.info("api info=> ", repositoryServiceRestaurant);
        return mapper.toDto(repositoryServiceRestaurant);
    }

    private void validateRestaurantDTO(RestaurantDTO restaurantDTO) {
        String[] requiredFields = {restaurantDTO.getName(), restaurantDTO.getAddress(),
                restaurantDTO.getCuisine(), restaurantDTO.getHours()};

        if (Arrays.stream(requiredFields).anyMatch(Objects::isNull)) {
            throw new RestaurantNotFoundException("Invalid RestaurantDTO. Name, Address, Cuisine, and Hours are required.");
        }
    }

    private static void genrateRandonUUIDIfIdIsNull(RestaurantDTO restaurantDTO) {
        if (restaurantDTO.getId() == null) {
            UUID randomUUID = UUID.randomUUID();
            restaurantDTO.setId(randomUUID.toString());
        }
    }

    @Override
    @Transactional
    public RestaurantDTO getRestaurantById(String id) {
        Restaurant serviceRestaurantById = repositoryService.getRestaurantById(id);

        return mapper.toDto(serviceRestaurantById);

    }

    @Override
    @Transactional
    public List<RestaurantDTO> getAllRestaurants() {
        return repositoryService.getAllRestaurantsIncludingDeleted().stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    @Transactional
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant existingRestaurant = repositoryService.getRestaurantById(restaurantDTO.getId());
        mapper.updateEntityFromDto(existingRestaurant, restaurantDTO);
        existingRestaurant.setVersion(existingRestaurant.getVersion() + 1);

        return mapper.toDto(repositoryService.updateRestaurant(existingRestaurant));
    }

    @Override
    public void softDeleteRestaurant(String id) {
        repositoryService.softDeleteRestaurant(id);
    }

    @Override
    @Transactional
    public List<RestaurantDTO> getRestaurantsByCuisine(String cuisine) {
        return repositoryService.getRestaurantsByCuisine(cuisine).stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
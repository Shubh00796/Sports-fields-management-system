package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.Domain.Restaurant;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Exceptions.RestaurantNotFoundException;
import com.sports.fieldsmanagementsystem.Reposiotry.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RestaurantRepositoryService {
    private final RestaurantRepository repository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);

    }

    public Restaurant getRestaurantById(String id) {
        return getCurrentRestaurant(id);
    }

    private Restaurant getCurrentRestaurant(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("id with given restaurant not found" + id));
    }

    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }

    public Restaurant updateRestaurant(String id, Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public void softDeleteRestaurant(String id) {
        repository.softDeleteById(id);
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return repository.findByCuisineContaining(cuisine);
    }

    public List<Restaurant> getAllRestaurantsIncludingDeleted() {
        return repository.findAllIncludingDeleted();
    }
}

package com.sports.fieldsmanagementsystem.Service;

import com.sports.fieldsmanagementsystem.DTOs.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO getRestaurantById(String id);

    List<RestaurantDTO> getAllRestaurants();

    RestaurantDTO updateRestaurant( RestaurantDTO restaurantDTO);

    void softDeleteRestaurant(String id); // New method for soft deletion

    List<RestaurantDTO> getRestaurantsByCuisine(String cuisine);

}

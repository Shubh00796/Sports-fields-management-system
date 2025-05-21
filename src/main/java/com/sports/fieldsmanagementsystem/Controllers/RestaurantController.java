package com.sports.fieldsmanagementsystem.Controllers;

import com.sports.fieldsmanagementsystem.DTOs.RestaurantDTO;
import com.sports.fieldsmanagementsystem.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO createdDTO = restaurantService.createRestaurant(restaurantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable String id) {
        RestaurantDTO restaurantDTO = restaurantService.getRestaurantById(id);
        // Consider handling null with a custom exception or ResponseEntity.notFound()
        return ResponseEntity.ok(restaurantDTO);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<RestaurantDTO> allRestaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(allRestaurants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@PathVariable String id, @RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO updatedDTO = restaurantService.updateRestaurant(restaurantDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}/soft")
    public ResponseEntity<Void> softDeleteRestaurant(@PathVariable String id) {
        restaurantService.softDeleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<RestaurantDTO>> getRestaurantsByCuisine(@PathVariable String cuisine) {
        List<RestaurantDTO> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        return ResponseEntity.ok(restaurants);
    }
}
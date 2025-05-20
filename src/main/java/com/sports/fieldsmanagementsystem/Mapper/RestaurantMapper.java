package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.RestaurantDTO;
import com.sports.fieldsmanagementsystem.Domain.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantDTO toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDTO restaurantDTO);

    void updateEntityFromDto(RestaurantDTO restaurantDTO, @MappingTarget Restaurant restaurant);
}

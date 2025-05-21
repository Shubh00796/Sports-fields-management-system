package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.RestaurantDTO;
import com.sports.fieldsmanagementsystem.Domain.Restaurant;
import org.mapstruct.*;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "cuisine", source = "cuisine"),
            @Mapping(target = "hours", source = "hours"),
            @Mapping(target = "deleted", source = "deleted"),
            @Mapping(target = "deletedAt", source = "deletedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    })
    RestaurantDTO toDto(Restaurant restaurant);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "cuisine", source = "cuisine"),
            @Mapping(target = "hours", source = "hours"),
            @Mapping(target = "deleted", source = "deleted"),
            @Mapping(target = "deletedAt", source = "deletedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    })
    Restaurant toEntity(RestaurantDTO restaurantDTO);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "cuisine", source = "cuisine"),
            @Mapping(target = "hours", source = "hours"),
            @Mapping(target = "deleted", source = "deleted"),
            @Mapping(target = "deletedAt", source = "deletedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    })
    void updateEntityFromDto(@MappingTarget Restaurant restaurant, RestaurantDTO restaurantDTO);
}
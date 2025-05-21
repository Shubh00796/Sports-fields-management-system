package com.sports.fieldsmanagementsystem.Reposiotry;

import com.sports.fieldsmanagementsystem.Domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    @Query("SELECT r FROM Restaurant r WHERE LOWER(r.cuisine) LIKE LOWER(CONCAT('%', :cuisine, '%'))")
    List<Restaurant> findByCuisineContaining(@Param("cuisine") String cuisine);


    @Query("SELECT r FROM Restaurant r")
    List<Restaurant> findAllIncludingDeleted();

    // Soft delete by ID
    @Modifying
    @Query("UPDATE Restaurant r SET r.deleted = TRUE, r.deletedAt = CURRENT_TIMESTAMP WHERE r.id = :id")
    void softDeleteById(@Param("id") String id);

}
package com.sports.fieldsmanagementsystem.Reposiotry;

import com.sports.fieldsmanagementsystem.Domain.SportField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface SportFieldRepository extends JpaRepository<SportField, Long> {

    List<SportField> findByType(String type);
    List<SportField> findByLocation(String location);
    @Query(value = "SELECT s.* FROM sport_fields s WHERE s.id NOT IN (SELECT booking.sport_field_id FROM booking WHERE booking.booking_date = ?1)",
            nativeQuery = true)
    List<SportField> getAvailableSportFields(LocalDate bookingDate);


}
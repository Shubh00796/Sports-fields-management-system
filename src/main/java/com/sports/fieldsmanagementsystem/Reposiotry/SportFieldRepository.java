package com.sports.fieldsmanagementsystem.Reposiotry;

import com.sports.fieldsmanagementsystem.Domain.SportField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SportFieldRepository extends JpaRepository<SportField, Long> {

    List<SportField> findByType(String type);
    List<SportField> findByLocation(String location);
    @Query("SELECT s FROM SportField s WHERE s.id NOT IN (SELECT b.sportFieldId FROM Booking b WHERE b.bookingDate = :date)")
    List<SportField> getAvailableSportFields(@Param("date") Date date);


}
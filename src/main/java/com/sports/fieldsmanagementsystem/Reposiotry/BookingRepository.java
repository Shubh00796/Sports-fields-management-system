package com.sports.fieldsmanagementsystem.Reposiotry;

import com.sports.fieldsmanagementsystem.Domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBySportFieldId(Long sportFieldId);

    List<Booking> findByBookingDate(Date bookingDate);

    List<Booking> findByClientPhone(String clientPhone);

    @Query("SELECT b FROM Booking b WHERE b.bookingDate > CURRENT_DATE")
    List<Booking> getUpcomingBookings();

    @Query("SELECT b FROM Booking b WHERE b.bookingDate < CURRENT_DATE")
    List<Booking> getPastBookings();

}
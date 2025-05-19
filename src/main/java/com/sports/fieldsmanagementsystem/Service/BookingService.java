package com.sports.fieldsmanagementsystem.Service;

import com.sports.fieldsmanagementsystem.DTOs.BookingDTO;

import java.util.Date;
import java.util.List;

public interface BookingService {

    List<BookingDTO> getAllBookings();

    BookingDTO getBookingById(Long id);

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(BookingDTO bookingDTO);

    void deleteBooking(Long id);

    // Additional methods
    List<BookingDTO> getBookingsBySportFieldId(Long sportFieldId);

    List<BookingDTO> getBookingsByDate(Date date);

    List<BookingDTO> getBookingsByClientPhone(String clientPhone);

    BookingDTO bookOutdoorField(BookingDTO bookingDTO);

    void cancelBooking(Long id);

    List<BookingDTO> getUpcomingBookings();

    List<BookingDTO> getPastBookings();
}
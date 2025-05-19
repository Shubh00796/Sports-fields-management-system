package com.sports.fieldsmanagementsystem.ReposiotryServices;

import com.sports.fieldsmanagementsystem.Domain.Booking;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Reposiotry.BookingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingReposiotryService {
    private final BookingsRepository bookingsRepository;

    public List<Booking> getAllBookings() {
        return bookingsRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id with given boking not found" + id));
    }

    public Booking createBooking(Booking booking) {
        return bookingsRepository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return bookingsRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }

    public List<Booking> getBookingsBySportFieldId(Long sportFieldId) {
        return bookingsRepository.findBySportFieldId(sportFieldId);
    }

    public List<Booking> getBookingsByDate(LocalDate date) {
        return bookingsRepository.findByBookingDate(date);
    }

    public List<Booking> getBookingsByClientPhone(String clientPhone) {
        return bookingsRepository.findByClientPhone(clientPhone);
    }


    public List<Booking> getUpcomingBookings() {
        return bookingsRepository.getUpcomingBookings();
    }

    public List<Booking> getPastBookings() {
        return bookingsRepository.getPastBookings();
    }
}


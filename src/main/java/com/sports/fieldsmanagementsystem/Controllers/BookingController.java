package com.sports.fieldsmanagementsystem.Controllers;

import com.sports.fieldsmanagementsystem.DTOs.BookingDTO;
import com.sports.fieldsmanagementsystem.Service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor

public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> allBookings = bookingService.getAllBookings();
        return ResponseEntity.ok(allBookings);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        BookingDTO booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookingDTO> createBooking(@RequestBody @Valid BookingDTO bookingDTO) {
        BookingDTO booking = bookingService.createBooking(bookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody @Valid BookingDTO bookingDTO) {
        bookingDTO.setId(id);
        BookingDTO updatedBooking = bookingService.updateBooking(bookingDTO);
        return ResponseEntity.ok(updatedBooking);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sport-field/{sportFieldId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookingDTO>> getBookingsBySportFieldId(@PathVariable Long sportFieldId) {
        List<BookingDTO> bookings = bookingService.getBookingsBySportFieldId(sportFieldId);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/date")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookingDTO>> getBookingsByDate(@RequestParam("date") LocalDate date) {
        List<BookingDTO> bookings = bookingService.getBookingsByDate(date);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/client-phone")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookingDTO>> getBookingsByClientPhone(@RequestParam("clientPhone") String clientPhone) {
        List<BookingDTO> bookings = bookingService.getBookingsByClientPhone(clientPhone);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/book-outdoor-field")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookingDTO> bookOutdoorField(@RequestBody @Valid BookingDTO bookingDTO) {
        BookingDTO bookedField = bookingService.bookOutdoorField(bookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookedField);
    }

    @DeleteMapping("/cancel/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/upcoming")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookingDTO>> getUpcomingBookings() {
        List<BookingDTO> upcomingBookings = bookingService.getUpcomingBookings();
        return ResponseEntity.ok(upcomingBookings);
    }

    @GetMapping("/past")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookingDTO>> getPastBookings() {
        List<BookingDTO> pastBookings = bookingService.getPastBookings();
        return ResponseEntity.ok(pastBookings);
    }


}

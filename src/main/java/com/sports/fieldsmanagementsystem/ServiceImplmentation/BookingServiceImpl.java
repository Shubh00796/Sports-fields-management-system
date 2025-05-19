package com.sports.fieldsmanagementsystem.ServiceImplmentation;

import com.sports.fieldsmanagementsystem.DTOs.BookingDTO;
import com.sports.fieldsmanagementsystem.Domain.Booking;
import com.sports.fieldsmanagementsystem.Exceptions.FieldTypeMismatchException;
import com.sports.fieldsmanagementsystem.Exceptions.ResourceNotFoundException;
import com.sports.fieldsmanagementsystem.Exceptions.WeatherException;
import com.sports.fieldsmanagementsystem.Mapper.BookingMapper;
import com.sports.fieldsmanagementsystem.ReposiotryServices.BookingReposiotryService;
import com.sports.fieldsmanagementsystem.Service.BookingService;
import com.sports.fieldsmanagementsystem.Service.SportFieldService;
import com.sports.fieldsmanagementsystem.Utils.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingReposiotryService reposiotryService;
    private final SportFieldService sportFieldService;
    private final BookingMapper mapper;
    private final WebClient webClient;
    private final WeatherService weatherService;


    @Override
    public List<BookingDTO> getAllBookings() {
        return reposiotryService.getAllBookings()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public BookingDTO getBookingById(Long id) {

        Booking booking = reposiotryService.getBookingById(id);
        return mapper.toDto(booking);
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        checkForTheAvaliableFields(bookingDTO);

        return mapper.toDto(reposiotryService.createBooking(mapper.toEntity(bookingDTO)));
    }

    private void checkForTheAvaliableFields(BookingDTO bookingDTO) {
        LocalDate bookingDate = bookingDTO.getBookingDate();
        if (sportFieldService.getAvailableSportFields(bookingDate) == null) {
            throw new ResourceNotFoundException("The selected sport field is not available on the specified date.");
        }
    }


    private boolean isOutdoorField(Long sportFieldId) {
        return !sportFieldService.getSportFieldById(sportFieldId).getIsIndoor();
    }

    @Override
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        Booking booking = reposiotryService.getBookingById(bookingDTO.getId());
        mapper.updateEntityFromDto(bookingDTO, booking);

        return mapper.toDto(reposiotryService.updateBooking(mapper.toEntity(bookingDTO)));
    }

    @Override
    public void deleteBooking(Long id) {
        reposiotryService.deleteBooking(id);

    }

    @Override
    public List<BookingDTO> getBookingsBySportFieldId(Long sportFieldId) {

        return reposiotryService.getBookingsBySportFieldId(sportFieldId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public List<BookingDTO> getBookingsByDate(LocalDate date) {
        return reposiotryService.getBookingsByDate(date)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public List<BookingDTO> getBookingsByClientPhone(String clientPhone) {
        return reposiotryService.getBookingsByClientPhone(clientPhone)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public BookingDTO bookOutdoorField(BookingDTO bookingDTO) {
        checkForWeather(bookingDTO);

        return mapper.toDto(reposiotryService.updateBooking(mapper.toEntity(bookingDTO)));
    }

    @Override
    public void cancelBooking(Long id) {
        reposiotryService.deleteBooking(id);

    }

    @Override
    public List<BookingDTO> getUpcomingBookings() {
        return reposiotryService.getUpcomingBookings()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public List<BookingDTO> getPastBookings() {
        return reposiotryService.getPastBookings()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private void checkForWeather(BookingDTO bookingDTO) {
        checkForOutdoorField(bookingDTO);

        if (!weatherService.isTemperatureAbove10(bookingDTO)) {
            throw new WeatherException("Temperature is not above 10°C");
        }
    }

    private void checkForOutdoorField(BookingDTO bookingDTO) {
        if (!isOutdoorField(bookingDTO.getSportFieldId())) {
            throw new FieldTypeMismatchException("Selected field is not an outdoor field");
        }
    }
}

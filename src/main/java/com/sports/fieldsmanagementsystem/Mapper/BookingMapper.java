package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.BookingDTO;
import com.sports.fieldsmanagementsystem.Domain.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingDTO toDto(Booking booking);

    Booking toEntity(BookingDTO bookingDTO);

    void updateEntityFromDto(BookingDTO bookingDTO, @MappingTarget Booking booking);
}
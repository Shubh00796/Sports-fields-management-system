package com.sports.fieldsmanagementsystem.Mapper;

import com.sports.fieldsmanagementsystem.DTOs.BookingDTO;
import com.sports.fieldsmanagementsystem.DTOs.SportFieldDTO;
import com.sports.fieldsmanagementsystem.Domain.Booking;
import com.sports.fieldsmanagementsystem.Domain.SportField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "clientPhone", source = "clientPhone")
    @Mapping(target = "clientEmail", source = "clientEmail")
    @Mapping(target = "sportFieldId", source = "sportFieldId")
    @Mapping(target = "bookingDate", source = "bookingDate")
    @Mapping(target = "bookingHour", source = "bookingHour")
    BookingDTO toDto(Booking booking);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "clientPhone", source = "clientPhone")
    @Mapping(target = "clientEmail", source = "clientEmail")
    @Mapping(target = "sportFieldId", source = "sportFieldId")
    @Mapping(target = "bookingDate", source = "bookingDate")
    @Mapping(target = "bookingHour", source = "bookingHour")
    Booking toEntity(BookingDTO bookingDTO);

    @Mapping(target = "id", source = "id")
    void updateEntityFromDto(BookingDTO bookingDTO, @MappingTarget Booking booking);
}
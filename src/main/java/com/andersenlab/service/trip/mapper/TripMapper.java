package com.andersenlab.service.trip.mapper;

import com.andersenlab.service.trip.dto.ResponseTripDto;
import com.andersenlab.service.trip.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper
@MapperConfig
public interface TripMapper {

  //  @Mapping(target = "intId", source = "trip.tripId")
  ResponseTripDto toResponseTripDto(Trip trip);
}

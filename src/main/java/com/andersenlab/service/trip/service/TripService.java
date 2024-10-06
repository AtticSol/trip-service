package com.andersenlab.service.trip.service;

import com.andersenlab.service.trip.dto.CreateTripBaseDto;
import com.andersenlab.service.trip.dto.RequestShareTripDto;
import com.andersenlab.service.trip.dto.RequestUpdateTripDto;
import com.andersenlab.service.trip.dto.ResponseTripDto;
import java.util.UUID;

public interface TripService {

  // Логика создания поездки, взаимодействие с MapService и GoogleCalendarService
  ResponseTripDto createTrip(CreateTripBaseDto tripBaseDto);

  ResponseTripDto updateTrip(UUID tripId, RequestUpdateTripDto updateTripDto);

  void deleteTrip(UUID tripId);

  ResponseTripDto getTripInfoById(UUID tripId);

  void shareTrip(UUID tripId, RequestShareTripDto shareTrip);
}

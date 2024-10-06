package com.andersenlab.service.trip.controller;

import com.andersenlab.service.trip.dto.RequestCreateNewTripDto;
import com.andersenlab.service.trip.dto.RequestCreatePastTripDto;
import com.andersenlab.service.trip.dto.RequestShareTripDto;
import com.andersenlab.service.trip.dto.RequestUpdateTripDto;
import com.andersenlab.service.trip.dto.ResponseTripDto;
import com.andersenlab.service.trip.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/v1/trips")
// @Validated
@RequiredArgsConstructor
// @SecurityRequirement(name = "Authorization")
public class TripController {

  private final TripService tripService;

  @PostMapping
  @Operation(summary = "Create trip")
  public ResponseTripDto createTrip(@RequestBody @Valid RequestCreateNewTripDto createNewTripDto) {
    return tripService.createTrip(createNewTripDto);
  }

  @PutMapping("/{tripId}")
  @Operation(summary = "Update trip")
  public ResponseTripDto updateTrip(
      @PathVariable UUID tripId, @RequestBody @Valid RequestUpdateTripDto updateTripDto) {
    return tripService.updateTrip(tripId, updateTripDto);
  }

  @DeleteMapping("/{tripId}")
  @Operation(summary = "Delete trip")
  public void deleteTrip(@PathVariable UUID tripId) {
    tripService.deleteTrip(tripId);
  }

  @Operation(summary = "Get info about trip")
  @GetMapping("/{tripId}")
  public ResponseTripDto getTripById(@PathVariable UUID tripId) {
    return tripService.getTripInfoById(tripId);
  }

  @Operation(summary = "Add past trip")
  @PostMapping("/past")
  public ResponseTripDto createPastTrip(
      @RequestBody @Valid RequestCreatePastTripDto createPastTripDto) {
    return tripService.createTrip(createPastTripDto);
  }

  @PostMapping("/{tripId}/share")
  public void shareTrip(
      @PathVariable UUID tripId, @RequestBody @Valid RequestShareTripDto shareTrip) {
    tripService.shareTrip(tripId, shareTrip);
  }
}

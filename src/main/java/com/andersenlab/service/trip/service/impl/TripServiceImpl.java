package com.andersenlab.service.trip.service.impl;

import com.andersenlab.service.trip.dto.CreateTripBaseDto;
import com.andersenlab.service.trip.dto.RequestShareTripDto;
import com.andersenlab.service.trip.dto.RequestUpdateTripDto;
import com.andersenlab.service.trip.dto.ResponseTripDto;
import com.andersenlab.service.trip.entity.Trip;
import com.andersenlab.service.trip.mapper.TripMapper;
import com.andersenlab.service.trip.repository.TripRepository;
import com.andersenlab.service.trip.service.TripService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {
  private final TripRepository tripRepository;
  private final TripMapper tripMapper;

  @Override
  @Transactional
  public ResponseTripDto createTrip(CreateTripBaseDto tripDto) {
    Trip trip =
        Trip.builder()
            .tripName(tripDto.getName())
            .tripStartDate(tripDto.getStartDate())
            .tripEndDate(tripDto.getEndDate())
            .organizerId(tripDto.getOrganizerId())
            .participantIds(tripDto.getParticipantIds())
            .build();

    return tripMapper.toResponseTripDto(tripRepository.save(trip));
  }

  @Override
  @Transactional
  public ResponseTripDto updateTrip(UUID tripId, RequestUpdateTripDto updateTripDto) {
    UUID organizerId = updateTripDto.getOrganizerId();
    Trip trip =
        tripRepository
            .findByTripIdAndOrganizerId(tripId, organizerId)
            .orElseThrow(); // todo: update error

    trip.setTripStartDate(updateTripDto.getStartDate());
    trip.setTripEndDate(updateTripDto.getEndDate());
    trip.setParticipantIds(updateTripDto.getParticipantIds());

    return tripMapper.toResponseTripDto(tripRepository.save(trip));
  }

  @Override
  @Transactional
  public void deleteTrip(UUID tripId) {
    Trip trip = tripRepository.findById(tripId).orElseThrow(); // todo: update error
    tripRepository.delete(trip);
  }

  @Override
  @Transactional
  public ResponseTripDto getTripInfoById(UUID tripId) {
    return tripMapper.toResponseTripDto(
        tripRepository.findById(tripId).orElseThrow()); // todo: update error
  }

  @Override
  public void shareTrip(UUID tripId, RequestShareTripDto shareTrip) {
    // В методе shareTrip можно добавить логику отправки уведомлений:
    //    for (User participant : participants) {
    //      notificationService.sendTripSharedNotification(participant.getId(), trip);
    //    }

    // Убедитесь, что текущий пользователь (владелец поездки) имеет право делиться этой поездкой, и
    // что участники, с которыми он делится поездкой, существуют в системе.
  }
}

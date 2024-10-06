package com.andersenlab.service.trip.repository;

import com.andersenlab.service.trip.entity.Trip;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {

  Optional<Trip> findByTripIdAndOrganizerId(UUID tripId, UUID organizerId);
}

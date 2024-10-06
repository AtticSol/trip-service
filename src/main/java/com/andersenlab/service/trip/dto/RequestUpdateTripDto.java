package com.andersenlab.service.trip.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestUpdateTripDto {

  // todo: add constraints, for ex.:
  //  1) required date or participants - perhaps redundant
  //  2) UUIDTypeValidator

  @NotNull private UUID organizerId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private List<UUID> participantIds;
}

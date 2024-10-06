package com.andersenlab.service.trip.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RequestShareTripDto {
  //  @NotNull private UUID tripId;
  @NotNull private List<UUID> userIds;
}

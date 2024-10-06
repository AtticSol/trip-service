package com.andersenlab.service.trip.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public abstract class CreateTripBaseDto {
  @NotBlank private String name;
  @NotNull private UUID organizerId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private List<UUID> participantIds;
}

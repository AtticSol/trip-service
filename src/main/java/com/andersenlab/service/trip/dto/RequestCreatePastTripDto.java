package com.andersenlab.service.trip.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RequestCreatePastTripDto extends CreateTripBaseDto {
  // todo:
  //  add constraint: exclude orgId from participants
  //  add constraint: past date

  @NotNull private LocalDateTime startDate;
  @NotNull private LocalDateTime endDate;
}

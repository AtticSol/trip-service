package com.andersenlab.service.trip.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visited_place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitedPlace {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false, name = "visited_place_id")
  private UUID visitedPlaceId; // Уникальный идентификатор посещенного места

  @Column(name = "place_name", nullable = false)
  private String placeName; // Название места

  @Column(name = "country", nullable = false)
  private String country;

  //  private String description;               // Описание места (опционально)

  @Column(name = "latitude", nullable = false)
  private Double latitude; // Широта (координата)

  @Column(name = "longitude", nullable = false)
  private Double longitude; // Долгота (координата)

  @Column(name = "photo_url") // todo: , nullable = false)
  private String photoUrl; //  URL для фотографий места / id из file-manger-service

  @Column(name = "visit_date", nullable = false)
  private LocalDateTime visitDate; // Дата и время посещения места

  @ManyToOne
  @JoinColumn(name = "trip_id", nullable = false)
  private Trip trip;
}

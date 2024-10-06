package com.andersenlab.service.trip.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trip")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false, name = "trip_id")
  private UUID tripId; // Уникальный идентификатор поездки

  @Column(name = "trip_name", nullable = false)
  private String tripName; // Название поездки

  @Column(name = "trip_start_date", nullable = false)
  private LocalDateTime tripStartDate; // Дата начала поездки

  @Column(name = "trip_end_date", nullable = false)
  private LocalDateTime tripEndDate; // Дата окончания поездки

  @Column(updatable = false, nullable = false, name = "organizer_id")
  private UUID organizerId; // Организатор поездки

  @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<VisitedPlace> visitedPlaces; // Список посещенных мест в поездке

  @ElementCollection
  @CollectionTable(name = "trip_participant", joinColumns = @JoinColumn(name = "trip_id"))
  @Column(name = "participant_id")
  private List<UUID> participantIds; // Список участников поездки

  //  @Column(nullable = false)
  //  private boolean shared;                   // Флаг, поделился ли пользователь этой поездкой с
  // друзьями

  @Column(insertable = false, updatable = false, name = "created_at")
  private LocalDateTime createdAt;
}

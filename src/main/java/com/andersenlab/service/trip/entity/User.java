// package com.andersenlab.service.trip.entity;
//
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;
// import java.util.List;
// import java.util.UUID;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
//
// @Entity
// @Table(name = "user_info")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class User {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.UUID)
//  @Column(updatable = false, nullable = false, name = "user_info_id")
//  private UUID userInfoId; // Уникальный идентификатор пользователя
//
//  @Column(nullable = false, unique = true)
//  private String username; // Имя пользователя
//
//  @Column(nullable = false, unique = true)
//  private String email; // Email пользователя
//
//  @ManyToMany(mappedBy = "participants")
//  private List<Trip> trips; // Список поездок, в которых участвует пользователь
//
//  // Конструкторы, геттеры и сеттеры
//
// }

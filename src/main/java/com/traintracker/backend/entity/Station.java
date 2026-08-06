package com.traintracker.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 10)
    private String stationCode;
    @Column(nullable = false, length = 100)
    private String stationName;
    @Column(nullable = false, length = 100)
    private String state;
    @Column(nullable = false, length = 100)
    private String zone;
    @Column(nullable = false, length = 100)
    private String division;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;

}
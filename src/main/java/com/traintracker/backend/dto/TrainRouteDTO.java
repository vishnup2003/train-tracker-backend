package com.traintracker.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class TrainRouteDTO {

    private Integer sequence;
    private String stationCode;
    private String stationName;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private Integer distanceKm;
}
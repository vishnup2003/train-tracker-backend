package com.traintracker.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LiveStatusDTO {

    private String trainNumber;
    private String trainName;

    private String currentStationCode;
    private String currentStationName;

    private String nextStationCode;
    private String nextStationName;

    private Integer delayMinutes;

    private LocalDateTime lastUpdated;
}
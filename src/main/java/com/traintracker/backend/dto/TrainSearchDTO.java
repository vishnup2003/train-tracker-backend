package com.traintracker.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrainSearchDTO {

    private String trainNumber;
    private String trainName;
}
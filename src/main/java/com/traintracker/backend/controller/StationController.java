package com.traintracker.backend.controller;

import com.traintracker.backend.entity.Station;
import com.traintracker.backend.service.StationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public Station saveStation(@RequestBody Station station) {
        return stationService.saveStation(station);
    }

}
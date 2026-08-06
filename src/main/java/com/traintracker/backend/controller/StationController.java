package com.traintracker.backend.controller;

import com.traintracker.backend.entity.Station;
import com.traintracker.backend.service.StationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }

    @PutMapping("/{id}")
    public Station updateStation(@PathVariable Long id, @RequestBody Station station){
        return stationService.updateStation(id, station);
    }

    @DeleteMapping("/{id}")
    public String deleteStation(@PathVariable Long id){
        stationService.deleteStation(id);
        return "Station Deleted Successfully";
    }

}